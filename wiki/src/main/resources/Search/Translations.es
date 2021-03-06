<?xml version="1.0" encoding="UTF-8"?>

<xwikidoc>
<web>Search</web>
<name>Translations</name>
<language>es</language>
<defaultLanguage></defaultLanguage>
<translation>1</translation>
<parent></parent>
<creator>XWiki.ShermanTank</creator>
<author>XWiki.ShermanTank</author>
<customClass></customClass>
<contentAuthor>XWiki.ShermanTank</contentAuthor>
<creationDate>1229984483000</creationDate>
<date>1229984483000</date>
<contentUpdateDate>1234995980000</contentUpdateDate>
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
<name>Search.Translations</name>
<number>0</number>
<className>XWiki.TagClass</className>
<property>
<tags/>
</property>
</object>
<content>&lt;pre&gt;
## SEARCH AND BROWSE BY SUBJECT TRANSLATION PAGE

## I am making a global assumption that I only need to include strings that are not already covered in classes. To see the lookup strings for the classes, go here. XWiki/GlobalClassTranslation

## If a string has the word "placeholder" after the "=" sign, it means text is coming. If it is blank after the "=" sign, that means the string can be ignored until further notice.

## CONFIGURATION
search.results.max= 500

## SEARCH ENTRY BOX AND OVERALL ITEMS

search.text.entry.label= Escriba los términos de búsqueda
search.text.entry.button= Buscar &amp;raquo;
search.text.entry.help.link= Sugerencias para buscar
search.text.entry.help.title= Sugerencias para buscar

## Tab titles
##{0} is tab name, {1} is search result count, and {2} is the total count
search.tab.title.results= {0} ({1})
search.tab.title.resultsmax_exceeds= {0} ({2})


## Search Tips Page
search.text.entry.help.text= 

search.text.entry.help.button= Sugerencias para buscar
search.find.no.results= No hay resultados que se ajusten a su búsqueda. Vuelva a intentarlo.
search.find.no.results.button= OK
search.advanced.search.button= Búsqueda Avanzada

search.columns.menu.columns= Columnas
search.columns.menu.sort_ascending= Orden ascendiente
search.columns.menu.sort_descending= Orden descendiente

search.pagination.pagesize.addbefore= 
search.pagination.pagesize.before= Mostrar
search.pagination.pagesize.after= 
search.pagination.pagesize.addafter= 

search.pagination.displaying.resource= Mostrando recursos {0} - {1} de aproximadamente {2}
search.pagination.displaying.resource_resultsmax_exceeds= Mostrando recursos {0} - {1} de los primeros {2}

search.pagination.displaying.group= Mostrando grupos {0} - {1} de aproximadamente {2}
search.pagination.displaying.group_resultsmax_exceeds= Mostrando grupos {0} - {1} de los primeros{2}

search.pagination.displaying.member= Mostrando miembros {0} - {1} de aproximadamente {2}
search.pagination.displaying.member_resultsmax_exceeds= Mostrando miembros {0} - {1} de los primeros {2}

search.pagination.displaying.blog= Mostrando Blogs {0} - {1} de aproximadamente {2}
search.pagination.displaying.blog_resultsmax_exceeds= Mostrando Blogs {0} - {1} de los primeros {2}

search.pagination.displaying.curriki= Mostrando páginas {0} - {1} de aproximadamente {2}
search.pagination.displaying.curriki_resultsmax_exceeds= Mostrando páginas {0} - {1} de los primeros {2}

## Pagination Buttons
search.pagination.first.button= &amp;lt;&amp;lt;Primero
search.pagination.prev.button= &amp;lt;Anterior
search.pagination.next.button= Siguiente&amp;gt; 
search.pagination.last.button= Último&amp;gt;&amp;gt; 

## Pagination Buttons Rollovers
search.pagination.beforepage= Página
search.pagination.afterpage= de aproximadamente {0}
search.pagination.afterpage_resultsmax_exceeds= de {0}
search.pagination.first= Primera página
search.pagination.prev= Página anterior
search.pagination.next= Siguiente página
search.pagination.last= Última página
search.pagination.refresh= Refrescar


##
##
##RESOURCES TAB

search.resource.tab.title= Recursos

##SUBJECT
## The naming convention follows the asset class names but is NOT part of the asset class

XWiki.AssetClass_fw_items_FW_masterFramework.UNSPECIFIED= Tema: Cualquiera


XWiki.AssetClass_fw_items_UNCATEGORIZED= Sin categorizar

##SUBJECT SUB SELECTION
## The naming convention follows the asset class names but is NOT part of the asset class

XWiki.AssetClass_fw_items_FW_masterFramework.Arts.UNSPECIFIED= Artes: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.VocationalEducation.UNSPECIFIED= Carreras y Educación Técnica: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.Education&amp;Teaching.UNSPECIFIED= Educación: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.EducationalTechnology.UNSPECIFIED= Tecnología Educacional: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.Health.UNSPECIFIED= Salud: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.Information&amp;MediaLiteracy.UNSPECIFIED= Conocimiento de los Medios e Información: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.LanguageArts.UNSPECIFIED= Artes del Lenguage: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.Mathematics.UNSPECIFIED= Matemáticas: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.Science.UNSPECIFIED= Ciencia: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.SocialStudies.UNSPECIFIED= Estudios Sociales: Cualquiera
XWiki.AssetClass_fw_items_FW_masterFramework.ForeignLanguages.UNSPECIFIED= Lenguas Extranajeras: Cualquiera

##EDUCATIONAL LEVEL
## The naming convention follows the asset class names but is NOT part of the asset class. 


XWiki.AssetClass_educational_level2_UNSPECIFIED= Nivel Educativo: Cualquiera

##ICT
## The naming convention follows the asset class names but is NOT part of the asset class

XWiki.AssetClass_instructional_component2_UNSPECIFIED= Tipo Instruccional: Cualquiera

##The ICT used in the columns are different than what is used in the drop down. These are from GWT with updated keys.

##For ICT Column
search.resource.ict.activity= Actividad
search.resource.ict.activity.assignment= Deberes
search.resource.ict.activity.exercise= Ejercicio

search.resource.ict.activity.lab= Experimento/Laboratorio
search.resource.ict.activity.worksheet= Organizador Gráfico/Tabla
search.resource.ict.activity.problemset= Serie de Problemas
search.resource.ict.book= Libro
search.resource.ict.book.fiction= Ficción
search.resource.ict.book.nonfiction= No Ficción
search.resource.ict.book.readings= Lecturas/Pasajes
search.resource.ict.book.textbook= Libro de Texto
search.resource.ict.curriculum= Plan de Estudios
search.resource.ict.curriculum.assessment= Evaluación/Examen
search.resource.ict.curriculum.course= Curso Completo
search.resource.ict.curriculum.unit= Unidad
search.resource.ict.curriculum.lp= Plan de Lección
search.resource.ict.curriculum.rubric= Guía de Evaluación
search.resource.ict.curriculum.scope= Alcance y Secuencia
search.resource.ict.curriculum.standards= Estándares
search.resource.ict.curriculum.studyguide= Guía de Estudio/Notas
search.resource.ict.curriculum.syllabus= Programa de Curso
search.resource.ict.curriculum.tutorial= Tutorial
search.resource.ict.curriculum.workbook= Cuaderno de Trabajo
search.resource.ict.resource= Recurso
search.resource.ict.resource.animation= Animación/Simulación
search.resource.ict.resource.diagram= Diagrama/Ilustración
search.resource.ict.resource.glossary= Glosario/Vocabulario
search.resource.ict.resource.index= Índice/Lista
search.resource.ict.resource.photograph= Fotografía
search.resource.ict.resource.presentation= Video/Presentación/Diapositivas
search.resource.ict.resource.collection= Colección de Referencia
search.resource.ict.resource.script= Guión/Transcripción
search.resource.ict.resource.speech= Audio/Discurso/Lección
search.resource.ict.resource.table= Tabla/Gráfico
search.resource.ict.resource.template= Plantilla
search.resource.ict.resource.webcast= Webcast/Podcast
search.resource.ict.other= Otros
search.resource.ict.multiple= Múltiple
search.resource.ict.unknown= 




##ICT SUB SELECTIONS
## The naming convention follows the asset class names but is NOT part of the asset class. 

XWiki.AssetClass_instructional_component2_activity= Actividad
XWiki.AssetClass_instructional_component2_book= Libro
XWiki.AssetClass_instructional_component2_curriculum= Plan de Estudios
XWiki.AssetClass_instructional_component2_resource= Recurso

XWiki.AssetClass_instructional_component2_activity_UNSPECIFIED= Actividad: Cualquiera
XWiki.AssetClass_instructional_component2_book_UNSPECIFIED= Libro: Cualquiera
XWiki.AssetClass_instructional_component2_curriculum_UNSPECIFIED= Plan de Estudios: Cualquiera
XWiki.AssetClass_instructional_component2_resource_UNSPECIFIED= Recurso: Cualquiera


##LANGUAGE
## The naming convention follows the asset class names but is NOT part of the asset class. 

XWiki.AssetClass_language_UNSPECIFIED= Idioma: Cualquiera

##REVIEW
## Dave not sure if you want to follow the CRS.CurrikiReviewStatusClass naming convention.

## CRS.CurrikiReviewStatusClass_status_any=Reviews: Any
## CRS.CurrikiReviewStatusClass_status_P=Partner
## CRS.CurrikiReviewStatusClass_status_highest_rated=Highest Rated

search.resource.review.selector.UNSPECIFIED= Revisiones: cualquiera
search.resource.review.selector.partners= Socios
search.resource.review.selector.highest_rated= Los mejores en la clasificación

##For Review column

search.resource.review.800= Ejemplar
search.resource.review.700= Parte de un recurso ejemplar
search.resource.review.600= Bueno
search.resource.review.500= Parte de un recurso bueno
search.resource.review.400= Básico
search.resource.review.300= Parte de un recurso Básico
search.resource.review.200= Socio
search.resource.review.100= No Evaluado/No Evaluable
search.resource.review.0= Revisión Pendiente


##SPECIAL FILTERS
## I don't think there is a Class I can model after here.
search.resource.special.selector.UNSPECIFIED= Filtros especiales: ninguno
search.resource.special.selector.contributions= Sólo mis contribuciones
search.resource.special.selector.collections= Sólo colecciones
search.resource.special.selector.resources= Sólo ficheros de recursos
search.resource.special.selector.updated= Sólo los recientemente actualizados
search.resource.special.selector.updated.days= 30

##COLUMNS
search.resource.column.header.assetType= Tipo de recurso
search.resource.column.header.title= Título
search.resource.column.title.tooltip.title= Descripción
search.resource.column.header.ict= Tipo Instruccional
search.resource.column.header.contributor= Contribuidor
search.resource.column.header.rating= Puntuación
search.resource.column.header.updated= Actualización


search.resource.icon.plus.rollover= Este recurso es parte de una colección o carpeta. Haga clic aquí para expandirlo.
search.resource.icon.minus.rollover= Haga clic para ocultar

search.resource.icon.CollectionComposite.rollover= colección
search.resource.icon.FolderComposite.rollover= Carpeta

search.resource.icon.Text.rollover= Fichero
search.resource.icon.Image.rollover= Fichero
search.resource.icon.Attachment.rollover= Fichero
search.resource.icon.External.rollover= Fichero
search.resource.icon.VIDITalk.rollover= Fichero
search.resource.icon.Animation.rollover= Fichero
search.resource.icon.CBOEText.rollover= Fichero
search.resource.icon.HTMLText.rollover= Fichero
search.resource.icon.WikiText.rollover= Fichero
search.resource.icon.Archive.rollover= Fichero
search.resource.icon.Audio.rollover= Fichero
search.resource.icon.Invalid.rollover= Fichero
search.resource.icon.Protected.rollover= Fichero
search.resource.icon.Unknown.rollover= Fichero

search.resource.resource.expanded.title= Este recurso es parte de:


##
##
##GROUPS TAB

search.group.tab.title= Grupos

##SUBJECT

## The naming convention follows the class names but is NOT part of the class

XWiki.CurrikiSpaceClass_topic_FW_masterFramework.WebHome.UNSPECIFIED= Tema: Cualquiera


##SUBJECT SUB SELECTION
## The naming convention follows the class names but is NOT part of the class

XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Arts.UNSPECIFIED= Artes: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.VocationalEducation.UNSPECIFIED= Carreras y Educación Técnica: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Education&amp;Teaching.UNSPECIFIED= Educación: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.EducationalTechnology.UNSPECIFIED= Tecnología Educacional: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Health.UNSPECIFIED= Salud: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Information&amp;MediaLiteracy.UNSPECIFIED= Conocimiento de los Medios e Información: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.LanguageArts.UNSPECIFIED= Artes del Lenguage: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Mathematics.UNSPECIFIED= Matemáticas: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.Science.UNSPECIFIED= Ciencia: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.SocialStudies.UNSPECIFIED= Estudios Sociales: Cualquiera
XWiki.CurrikiSpaceClass_topic_FW_masterFramework.ForeignLanguages.UNSPECIFIED= Lenguas Extranajeras: Cualquiera


##EDUCATIONAL LEVEL

## The naming convention follows the class names but is NOT part of the class


XWiki.CurrikiSpaceClass_educationLevel_UNSPECIFIED= Nivel Educativo: Ninguno

##LANGUAGE

## The naming convention follows the class names but is NOT part of the class

XWiki.CurrikiSpaceClass_language_UNSPECIFIED= Idioma: Cualquiera

##MEMBERSHIP POLICIES
## These are from the class but they were modified locally in the Groups.Translation file. Thus I had to make new keys. I included them for reference only. Todd

## XWiki.SpaceClass_policy_any=Membership Policy: Any
## XWiki.SpaceClass_policy_open=Open Membership 
## XWiki.SpaceClass_policy_closed=Closed Membership

search.XWiki.SpaceClass_policy_UNSPECIFIED= Política de Asociación: Ninguna
search.XWiki.SpaceClass_policy_open= Abierto
search.XWiki.SpaceClass_policy_closed= Cerrado

##COLUMNS


search.group.icon.open= Abierto
search.group.icon.closed= Cerrado
search.group.icon.open.rollover= Grupo Abierto
search.group.icon.closed.rollover= Grupo Cerrado
search.group.column.header.policy= Política
search.group.column.header.name= Nombre
search.group.column.header.description= Descripción
search.group.column.header.updated= Actualizado


##
##
##MEMBERS

search.member.tab.title= Miembros

##SUBJECT
## The naming convention follows the class names but is NOT part of the class

XWiki.XWikiUsers_topics_FW_masterFramework.WebHome.UNSPECIFIED= Tema: Cualquiera

##SUBJECT SUB SELECTION
## The naming convention follows the class names but is NOT part of the class



XWiki.XWikiUsers_topics_FW_masterFramework.Arts.UNSPECIFIED= Arts: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.VocationalEducation.UNSPECIFIED= Carreras y Educación Técnica: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.Education&amp;Teaching.UNSPECIFIED= Educación: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.EducationalTechnology.UNSPECIFIED= Tecnología Educacional: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.Health.UNSPECIFIED= Salud: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.Information&amp;MediaLiteracy.UNSPECIFIED= Conocimiento de los Medios e Información: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.LanguageArts.UNSPECIFIED= Artes del Lenguage: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.Mathematics.UNSPECIFIED= Matemáticas: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.Science.UNSPECIFIED= Ciencia: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.SocialStudies.UNSPECIFIED= Estudios Sociales: Cualquiera
XWiki.XWikiUsers_topics_FW_masterFramework.ForeignLanguages.UNSPECIFIED= Lenguas Extranajeras: Cualquiera
##MEMBER TYPE
## The naming convention follows the class names but is NOT part of the class
XWiki.XWikiUsers_member_type_UNSPECIFIED= Tipo de Miembro: Cualquiera


##COUNTRY
## The naming convention follows the class names but is NOT part of the class

XWiki.XWikiUsers_country_UNSPECIFIED= País: Cualquiera


##COLUMNS

search.member.column.header.picture= Fotografía
search.member.column.header.name1= Nombre 1
search.member.column.header.name2= Nombre 2
search.member.column.header.bio= Biografía
search.member.column.header.contributions= Contribuciones
search.member.column.picture.alt.text= 

##
##
##BLOGS


search.blog.tab.title= Blogs


##COLUMNS

search.blog.column.header.name= Miembros
search.blog.column.header.text= Texto
search.blog.column.header.comments= Comentarios
search.blog.column.header.updated= Actualizado

##
##
##CURRIKI PAGE

search.curriki.tab.title= Páginas de Curriki

##PAGES OR SPACES TO SEARCH

search.curriki.space.page.1= Inicio
search.curriki.space.page.2= Noticias
search.curriki.space.page.3= Demo
search.curriki.space.page.4= Licencias

##COLUMNS

search.curriki.column.header.name= Página
search.curriki.column.header.text= Texto
search.curriki.column.header.updated= Actualizado

&lt;/pre&gt;
</content></xwikidoc>