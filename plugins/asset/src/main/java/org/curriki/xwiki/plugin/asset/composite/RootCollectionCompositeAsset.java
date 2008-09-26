package org.curriki.xwiki.plugin.asset.composite;

import com.xpn.xwiki.doc.XWikiDocument;
import com.xpn.xwiki.XWikiContext;
import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.objects.BaseObject;
import org.curriki.xwiki.plugin.asset.Constants;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.curriki.xwiki.plugin.asset.Asset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
public class RootCollectionCompositeAsset extends CollectionCompositeAsset {
    private static final Log LOG = LogFactory.getLog(RootCollectionCompositeAsset.class);

    public RootCollectionCompositeAsset(XWikiDocument doc, XWikiContext context) {
        super(doc, context);
    }

    protected String compositeAssetType() {
        return Constants.COMPOSITE_ASSET_CLASS_TYPE_ROOT_COLLECTION;
    }

    public boolean isRootCollection() {
        return true;
    }

    protected void setDefaultContent() throws XWikiException {
        assertCanEdit();
        doc.setContent("#includeForm(\"XWiki.MyCollectionsTemplate\")");
    }

    // Any added collections to the Root Collection go to the beginning of the list
    @Override
    public long addSubasset(String page) throws XWikiException {
        return insertSubassetAt(page, (long) 0);
    }

    @Override
    public List<String> getSubassetList() {
        // Default to ordering by name
        return getSubassetList("name");
    }
    /**
     * Get a list of subassets
     * 
     * @param order Either "name" or "date" as how unordered collections should show up
     * @return Ordered list of subassets
     */
    public List<String> getSubassetList(String order) {
        List<String> results = fetchOrderedCollectionsList();
        if (results != null) {
            return results;
        }

        return fetchCollectionsList(order);
    }

    public List<String> fetchOrderedCollectionsList() {
        XWikiDocument assetDoc = getDoc();
        BaseObject assetObj = assetDoc.getObject(Constants.COLLECTION_REORDERED_CLASS);
        Integer reordered;
        if (assetObj != null) {
            reordered = assetObj.getIntValue(Constants.COLLECTION_REORDERED_CLASS_REORDERD, 0);
            if (reordered == 1) {
                // If ordered give the ordered list
                List<BaseObject> objs = doc.getObjects(Constants.SUBASSET_CLASS);
                if (objs != null) {
                    Collections.sort(objs, new Comparator<BaseObject>(){
                        public int compare(BaseObject s1, BaseObject s2){
                            Long c1 = s1.getLongValue(Constants.SUBASSET_CLASS_ORDER);
                            Long c2 = s2.getLongValue(Constants.SUBASSET_CLASS_ORDER);
                            return (c1.compareTo(c2));
                        }
                    });

                    List<String> list = new ArrayList<String>();
                    for (Object obj: objs){
                        list.add(((BaseObject) obj).getStringValue(Constants.SUBASSET_CLASS_PAGE));
                    }

                    return filterViewablePages(list);
                }
            }
        }

        return null;
    }

    public List<String> fetchCollectionsList() {
        return fetchCollectionsList("name");
    }

    /**
     * Get a list of all viewable collections owned by a specific user
     *
     * @param order Return results in either "date" or "name" order
     * @return A list of collections
     */
    public List<String> fetchCollectionsList(String order) {
        String qry = ", BaseObject as obj, StringProperty as props "
                + "where obj.id=props.id.id and doc.fullName=obj.name "
                + "and obj.className='"+ Constants.COMPOSITE_ASSET_CLASS+"' "
                + "and doc.web=? "
                + (this.getSpace().startsWith("Coll_Group_")
                   ?""
                   :"and doc.name != '"+ Constants.FAVORITES_COLLECTION_PAGE+"' " // Only exclude for users
                  )
                + "and doc.name != '"+ Constants.ROOT_COLLECTION_PAGE+"' "
                + "and props.id.name='"+ Constants.COMPOSITE_ASSET_CLASS_TYPE+"' "
                + "and props.value='"+ Constants.COMPOSITE_ASSET_CLASS_TYPE_COLLECTION+"' "
                + (order.equals("name")
                   ?"order by doc.name"       // For lists like Choose Location Dialogue
                   :"order by doc.date desc"  // For lists like user collection list in MyCurriki
                  );

        List<String> params = new ArrayList<String>();
        params.add(this.getSpace());

        return fetchCollectionsList(qry, params);
    }

    protected List<String> fetchCollectionsList(String qry, List params) {
        List<String> results = new ArrayList<String>();
        try {
            List<String> list = context.getWiki().getStore().searchDocumentsNames(qry, 0, 0, params, context);

            results = filterViewablePages(list);
        } catch (Exception e) {
            // Ignore exception, but will end up returning empty list
            LOG.error("Error fetching collections", e);
        }

        return results;
    }

    public Map<String,Object> fetchCollectionsInfo() {
        return fetchCollectionsInfo("name");
    }
    
    /**
     * Get a list of all viewable collections owned by a specific user with extra info
     *
     * @param order Unordered collections in order of "name" or "date"
     * @return A list of collections with information about each
     */
    public Map<String,Object> fetchCollectionsInfo(String order) {
        Map<String,Object> colInfo = new HashMap<String,Object>();
        List<String> collections = getSubassetList(order);

        for (String collection : collections) {
            try {
                Asset doc = fetchAsset(collection, context);
                if (doc != null) {
                    CollectionCompositeAsset cAsset = doc.as(CollectionCompositeAsset.class);
                    colInfo.put(collection, cAsset.getCollectionInfo());
                }
            } catch (Exception e) {
                // If we can't get the document then skip it
                LOG.error("Error fetching document", e);
            }
        }

        return colInfo;
    }
}
