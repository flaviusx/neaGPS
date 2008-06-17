// vim: ts=4:sw=4
/*global Curriki */
/*global _ */

Ext.ns('Curriki.assets');
Curriki.assets = {
	 json_prefix:'/xwiki/curriki/assets'
	,CreateAsset:function(parentPage, callback){
		Ext.Ajax.request({
			 url: this.json_prefix
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {'parent':parentPage||''}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with
				//   assetPage, assetType, and fullAssetType items
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot create resource');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot create resource', options);
				throw {message: "Server Error: Cannot create resource."};
			}
		});
	}
	,GetAssetInfo:function(assetPage, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage
			,method:'GET'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with metadata
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot get resource metadata');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot get resource metadata', options);
				throw {message: "Server Error: Cannot get resource metadata."};
			}
		});
	}
	,GetMetadata:function(assetPage, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/metadata'
			,method:'GET'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with metadata
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot get resource metadata');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot get resource metadata', options);
				throw {message: "Server Error: Cannot get resource metadata."};
			}
		});
	}
	,SetMetadata:function(assetPage, metadata, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/metadata'
			,method:'PUT'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: metadata
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with metadata
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot set resource metadata');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot set resource metadata', options);
				throw {message: "Server Error: Cannot set resource metadata."};
			}
		});
	}
	,CreateExternal:function(assetPage, linkUrl, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/externals'
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {'link':linkUrl}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with new ref info
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot create external link');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot create external link', options);
				throw {message: "Server Error: Cannot create external link."};
			}
		});
	}
	,CreateSubasset:function(assetPage, subassetPage, order, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/subassets'
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {page:subassetPage, order:order}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with new ref info
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot add subasset');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot add subasset', options);
				throw {message: "Server Error: Cannot add subasset."};
			}
		});
	}
	,CreateFolder:function(assetPage, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/subassets'
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {collectionType:'folder'}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object for the current asset
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot create folder');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot create folder', options);
				throw {message: "Server Error: Cannot create folder."};
			}
		});
	}
	,CreateCollection:function(assetPage, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/subassets'
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {collectionType:'collection'}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object for the current asset
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot create collection');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot create collection', options);
				throw {message: "Server Error: Cannot create collection."};
			}
		});
	}
	,CreateVIDITalk:function(assetPage, videoId, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/viditalks'
			,method:'POST'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {page:assetPage, videoId:videoId}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with new ref info
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot add video');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot add video', options);
				throw {message: "Server Error: Cannot add video."};
			}
		});
	}
	,Publish:function(assetPage, space, callback){
		Ext.Ajax.request({
			 url: this.json_prefix+'/'+assetPage+'/published'
			,method:'PUT'
			,headers: {
				'Accept':'application/json'
				,'Content-type':'application/json'
			}
			,jsonData: {space: space}
			,scope:this
			,success:function(response, options){
				var json = response.responseText;
				// Should return an object with the new asset URL
				var o = json.evalJSON(true);
				if(!o) {
					console.warn('Cannot publish resource');
					throw {message: "CreateAsset: Json object not found"};
				}
				callback(o);
			}
			,failure:function(response, options){
				console.error('Cannot publish resource', options);
				throw {message: "Server Error: Cannot publish resource."};
			}
		});
	}
}
