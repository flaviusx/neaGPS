<?xml version="1.0" encoding="UTF-8"?>

<xwikidoc>
<web>MyCurriki</web>
<name>Translations</name>
<language>es</language>
<defaultLanguage></defaultLanguage>
<translation>1</translation>
<parent></parent>
<creator>XWiki.ShermanTank</creator>
<author>XWiki.ShermanTank</author>
<customClass></customClass>
<contentAuthor>XWiki.ShermanTank</contentAuthor>
<creationDate>1229980780000</creationDate>
<date>1229980780000</date>
<contentUpdateDate>1234891124000</contentUpdateDate>
<version>1.1</version>
<title></title>
<template></template>
<defaultTemplate></defaultTemplate>
<validationScript></validationScript>
<comment></comment>
<minorEdit>false</minorEdit>
<syntaxId>xwiki/1.0</syntaxId>
<object>
<class>
<name>XWiki.TagClass</name>
<customClass></customClass>
<customMapping></customMapping>
<defaultViewSheet></defaultViewSheet>
<defaultEditSheet></defaultEditSheet>
<defaultWeb></defaultWeb>
<nameField></nameField>
<validationScript></validationScript>
<tags>
<cache>0</cache>
<displayType>select</displayType>
<multiSelect>1</multiSelect>
<name>tags</name>
<number>1</number>
<prettyName>Tags</prettyName>
<relationalStorage>1</relationalStorage>
<separator> </separator>
<separators> ,|</separators>
<size>30</size>
<unmodifiable>0</unmodifiable>
<values></values>
<classType>com.xpn.xwiki.objects.classes.StaticListClass</classType>
</tags>
</class>
<name>MyCurriki.Translations</name>
<number>0</number>
<className>XWiki.TagClass</className>
<property>
<tags/>
</property>
</object>
<content>#{pre}
mycurriki.datetimeFormat= MMM-dd-yyyy - hh:mm a z
mycurriki.dateFormat= MMM-dd-yyyy
mycurriki.timeFormat= hh:mm a z

mycurriki.tab.blog.label= Blog

mycurriki.tab.blog.subtitle= Encontrar todas las entradas de blogs escritas por {0}. Los miembros de Curriki pueden a����adir comentarios a cualquier entrada en un blog.
mycurriki.tab.blog.noblog.subtitle= Encontrar todas las entradas de blogs escritas por {0}. Los miembros de Curriki pueden a����adir comentarios a cualquier entrada en un blog.
mycurriki.tab.collections.label= Colecciones

mycurriki.tab.collections.subtitle= Encontrar todas las colecciones de planes de estudio en la lista que sigue.
mycurriki.tab.contributions.label= Contribuciones

mycurriki.tab.contributions.subtitle= Encontrar todas las contribuciones en la lista siguiente. Se puede ordenar por T����tulo, ����ltima Actualizaci����n, y Acceso. (S����lo ver���� Acceso para sus propias contribuciones.)
mycurriki.tab.favorites.label= Favoritos

mycurriki.tab.favorites.subtitle= Esta es la lista de sus favoritos.
mycurriki.tab.groups.label= Grupos

mycurriki.tab.groups.subtitle= Encontrar todos los grupos en la lista a continuaci����n
mycurriki.tab.profile.label= Perfil


##Do not translate these as they are links and need to use the english names. Todd Nov 17, 2008

mycurriki.tab.blog.page= Mi Curriki.Blog
mycurriki.tab.collections.page= Mi Curriki.Colecciones
mycurriki.tab.contributions.page= Mi Curriki.Contribuciones
mycurriki.tab.favorites.page= Mi Curriki.Favoritos
mycurriki.tab.groups.page= Mi Curriki.Grupos
mycurriki.tab.profile.page= Mi Curriki.Perfil

##PROFILE TAB

mycurriki.profile.titlebar= Informaci����n de miembro
mycurriki.profile.editButton= Editar Perfil
mycurriki.profile.needPicture= Por favor, selecciones un fichero (debe ser una imagen).

mycurriki.editprofile.titlebar= Editar la informaci����n de miembro
mycurriki.editprofile.saveButton= Guardar
mycurriki.editprofile.confirmLeave= Est���� saliendo de la p����gina de edici����n de perfil sin guardar sus cambios. ����Seguro que quiere salir y perder sus cambios?

##FAVORITES TAB

mycurriki.favorites.collection.title= Favoritos
mycurriki.favorites.collection.description= Favoritos
mycurriki.favorites.viewButton= Ver todos
mycurriki.favorites.table.title= T����tulos
mycurriki.favorites.table.contributor= Contribuido por
mycurriki.favorites.table.ict= ICT
mycurriki.favorites.table.filetype= Tipo de fichero
mycurriki.favorites.table.action= Acci����n
mycurriki.favorites.table.action.remove= Eliminar

mycurriki.favorites.table.action.remove.confirm= ����Seguro que quiere eliminar esto?
mycurriki.favorites.removed.comment= Se ha eliminado {0} de los favoritos.
mycurriki.favorites.noresults= 
mycurriki.favorites.mouseover.description= &lt;strong&gt;Descripci����n:&lt;/strong&gt;
mycurriki.favorites.mouseover.subject= &lt;strong&gt;Tema:&lt;/strong&gt;
mycurriki.favorites.mouseover.level= &lt;strong&gt;Nivel educativo:&lt;/strong&gt;

##CONTRIBUTIONS TAB

mycurriki.contributions.addButton= A����adir un recurso
mycurriki.contributions.addButton_tooltip= Comparta sus mejores recursos educativos o cree algo nuevo
mycurriki.contributions.table.title= T����tulo
mycurriki.contributions.table.ict= ICT
mycurriki.contributions.table.lastupdated= ����ltima Actualizaci����n
mycurriki.contributions.table.access= Acceso
mycurriki.contributions.table.filetype= Tipo de fichero
mycurriki.contributions.table.action= Acci����n
mycurriki.contributions.add= A����adir
mycurriki.contributions.add_tooltip= A����adir esto a una carpeta o colecci����n
mycurriki.contributions.noresults= 
mycurriki.contributions.actions.delete.confirm= ����Seguro que quiere borrar esta contribuci����n?

##COLLECTIONS TAB

mycurriki.collections.titlebar= Colecciones de planes de estudio
mycurriki.collections.buildup= Construir
mycurriki.collections.buildup_tooltip= a����adir algo a esta colecci����n
mycurriki.collections.titlebarbutton= Ocultar descripciones
mycurriki.collections.titlebarbuttonalt= Mostrar descripciones
mycurriki.collections.addButton= A����adir una colecci����n
mycurriki.collections.addButton_tooltip= A����adir una nueva colecci����n para organizar o mostrar recursos
mycurriki.collections.view= Ver
mycurriki.collections.edit= Editar
mycurriki.collections.add= A����adir
mycurriki.collections.delete= Borrar
mycurriki.collections.actions.delete.confirm= ����Seguro que quiere borrar esta colecci����n?
mycurriki.collections.noresults= 

##REORDER FEATURE

mycurriki.collections.reorder.link= Reordenar

mycurriki.collections.reorder.checkfirst.dialog= Por defecto, sus colecciones se muestran poniendo arriba la de actualizaci����n m����s reciente.&lt;br&gt;&lt;br&gt;����Quiere usar otro orden?&lt;br&gt;&lt;br&gt;Haga clic en OK para continuar.
mycurriki.collections.reorder.checkfirst.cancel.btt= OK
mycurriki.collections.reorder.checkfirst.next.btt= Cancelar

mycurriki.collections.reorder.dialog_title= Reordenar sus colecciones
mycurriki.collections.reorder.guidingquestion= ����En qu���� orden le gustar����a mostrar sus colecciones de planes de estudios?
mycurriki.collections.reorder.instruction= Arrastre y suelte sus colecciones para colocarlas en el orden deseado; cuando haya acabado, haga clic en Siguiente.
mycurriki.collections.reorder.listheader= Colecciones
mycurriki.collections.reorder.cancel.btt= Cancelar
mycurriki.collections.reorder.next.btt= Siguiente

mycurriki.collections.reorder.error= Mientras usted estaba reordenando su colecci����n, una nueva colecci����n ha sido a����adida o sus colecciones han sido reordenadas. Dado que esta acci����n ha ocurrido mientras usted estaba trabajando, y antes de que guardase su orden preferido, tiene prioridad; el reordenamiento que usted ha enviado no ser���� aplicado. (Puede volver a hacer clic en el enlace para reordenar para empezar de nuevo.)
mycurriki.collections.reorder.error.ok.btt= OK

mycurriki.collections.reorder.set.confirm= Se ha guardado el nuevo orden.
mycurriki.collections.reorder.set.confirm.btt= OK

mycurriki.collections.reorder.checkafter.dialog= Ya ha establecido un orden especial para sus colecciones.&lt;br&gt;&lt;br&gt;����Quiere cambiarlo?&lt;br&gt;&lt;br&gt;Haga clic en Continuar.
mycurriki.collections.reorder.checkafter.cancel.btt= OK
mycurriki.collections.reorder.checkafter.next.btt= Cancelar

##BLOG TAB

mycurriki.blog.titlebar= Entradas de blog
mycurriki.blog.createEntry= A����adir una entrada
mycurriki.blog.createBlog= Crear un blog
mycurriki.blog.noblog= 
mycurriki.blog.postedBy= Escrito por {0} el {1} a las {2}
mycurriki.blog.comment.delete= Borrar
mycurriki.blog.comment.delete.confirm= ����Seguro que quiere borrar el comentario?
mycurriki.blog.comment.empty= Por favor, introduzca un comentario para guardarlo.
mycurriki.blog.actions.delete.confirm= ����Seguro que quiere borrar esta entrada de blog?

##GROUPS TAB

mycurriki.groups.visit= Visitar este grupo
mycurriki.groups.mymessages= Mis mensajes recientes
mycurriki.groups.viewmessages= Ver los mensajes del grupo &amp;raquo;
mycurriki.groups.message.by= por

mycurriki.macro.filetype.URL= URL
mycurriki.macro.filetype.unknown= Desconocido
mycurriki.macro.filetype.curriki= P����gina en Curriki
mycurriki.macro.filetype.currikulum= Plan de estudio

mycurriki.macro.access.public= P����blico

mycurriki.macro.access.members= Protegido
mycurriki.macro.access.private= Privado

mycurriki.macro.paginate.results= Resultados
mycurriki.macro.paginate.of= de unos
mycurriki.macro.paginate.previous= Anterior
mycurriki.macro.paginate.next= Siguiente
#{/pre}
</content></xwikidoc>