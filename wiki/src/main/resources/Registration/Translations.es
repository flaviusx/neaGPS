<?xml version="1.0" encoding="UTF-8"?>

<xwikidoc>
<web>Registration</web>
<name>Translations</name>
<language>es</language>
<defaultLanguage></defaultLanguage>
<translation>1</translation>
<parent></parent>
<creator>XWiki.ShermanTank</creator>
<author>XWiki.ShermanTank</author>
<customClass></customClass>
<contentAuthor>XWiki.ShermanTank</contentAuthor>
<creationDate>1229980570000</creationDate>
<date>1230055358000</date>
<contentUpdateDate>1234891124000</contentUpdateDate>
<version>2.1</version>
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
<name>Registration.Translations</name>
<number>0</number>
<className>XWiki.TagClass</className>
<property>
<tags/>
</property>
</object>
<content>#&lt;pre&gt;
#Main.ForgotPassword
forgotPassword.title= Contrase����a olvidada
forgotPassword.forgotUnameLink= ����Ha olvidado su nombre de usuario?
forgotPassword.infos= ����Ha olvidado su contrase����a? Nos ha pasado a todos. Escriba la direcci����n de correo con la que se registr���� y le enviaremos un e-mail con ayuda.
forgotPassword.enterEmail= Escriba su direcci����n de e-mail:
forgotPassword.noUser= Lo siento, no hay ning����n usuario con direcci����n {0}
forgotPassword.multipleUsers= Parece que hay varios nombres de usuario registrados con esta direcci����n. 
forgotPassword.emailSent= El password  de {0} ha sido enviado.
forgotPassword.invalidLink= Lo siento, el enlace que ha intentado visitar no es v����lido.
forgotPassword.passwordChanged= La contrase����a de {0} ha sido modificada.
forgotPassword.youCanLogIn= Ahora ya puede &lt;a href="{0}"&gt;entrar&lt;/a&gt;.
forgotPassword.passwordsDoesNotMatch= El nombre de usuario y contrase����a que ha introducido no encajan. Por favor, vuelva a intentarlo.
forgotPassword.enterPassword= Ahora puede introducir una nueva contrase����a:
forgotPassword.enterPassword.prompt= Por favor, introduzca una nueva contrase����a:
forgotPassword.enterPasswordConfirm.prompt= Por favor, confirme la nueva contrase����a:
forgotPassword.Go= ����Entre!
forgotPassword.email.mandatory= La direcci����n de correo electr����nico es necesaria.
forgotPassword.email.invalid= Se necesita una direcci����n de correo electr����nico v����lida.



#Main.ForgotPasswordEmail

forgotPasswordEmail.header= From: {0}To: {1}Subject: Su contrase����a en curriki.org
forgotPasswordEmail.part1= Estimado {0} {1},
forgotPasswordEmail.part2= ����Ha olvidado su contrase����a? Nos ha ocurrido a todos. Por razones de seguridad, s����lo guardamos una copia cifrada de su contrase����a, y por tanto no podemos decirle cu����l era, pero puede establecer una nueva contrase����a visitando el enlace {0}
forgotPasswordEmail.part3= Su contrase����a ser���� modificada y entonces usted podr���� volver a entrar normalmente en el sistema usando su nueva contrase����a.



#Main.ForgotUsername
forgotUsername.title= Nombre de usuario olvidado
forgotUsername.forgotPwdLink= ����Ha olvidado su nombre de usuario?
forgotUsername.infos= ����Ha olvidado su nombre de usuario? Nos ha ocurrido a todos. Escriba la direcci����n de correo con la que se registr���� y le enviaremos un e-mail que le ayudar���� a entrar.
forgotUsername.enterEmail= Por favor, escriba su direcci����n de correo:
forgotUsername.noUser= Lo siento, no hay ning����n usuario con la direcci����n de correo {0}
forgotUsername.emailSent= El nombre de usuario de {0} ha sido enviado por correo electr����nico.
forgotUsername.email.mandatory= Es necesario introducir la direcci����n de correo electr����nico.
forgotUsername.email.invalid= Se necesita una direcci����n v����lida de correo electr����nico.



#Main.ForgotUsernameEmail{0}

forgotUsernameEmail.header= From: {0}To: {1}Subject: Su nombre de usuario en curriki.org
forgotUsernameEmail.part1= Estimado {0} {1},
forgotUsernameEmail.part2= ����Ha olvidado su nombre de usuario? Nos ha ocurrido a todos. Usted seleccion���� '{0}' cuando se registr����. Si ha olvidado su contrase����a, haga click en "contrase����a olvidada" en la parte superior de cualquier p����gina de curriki.org y le enviaremos un mensaje de correo electr����nico con ayuda para reestablecer su contrase����a.



#Main.ForgotUsernamesEmail

forgotUsernamesEmail.part1= Querido usuario de curriki.org,
forgotUsernamesEmail.part2= ����Ha olvidado su nombre de usuario? Nos ha ocurrido a todos. En realidad, usted se ha registrado con varios nombres de usuario diferentes: '${names}'. Si ha olvidado su contrase����a, haga click en "contrase����a olvidada" en la p����gina de entrada, y le enviaremos un mensaje de correo electr����nico con ayuda para reestablecer su contrase����a.



#Main.JoinCurriki

joincurriki.first_name.text= Escoja un nombre por el que los miembros de Curriki le reconocer����n (por ejemplo, Nombre, t����tulo, apodo). 
joincurriki.last_name.text= Escoja otro nombre para tener un nombre ����nico (puede usar su apellido, compa��������a o ciudad)



joincurriki.fileds.xwikiname= Nombre de usuario
joincurriki.xwikiname.badchars= Este nombre de usuario es inv����lido. Por favor, introduzca un nombre de usuario sin espacios ni caracteres especiales.
joincurriki.repeat= repetir
joincurriki.registerToJoinCurriki= Reg����strese para hacerse miembro de Curriki.
joincurriki.infos= Gracias por unirse a la comunidad de Curriki. Unirse a Curriki es su primer paso para acceder y crear recursos docentes de alta calidad. &lt;br /&gt;&lt;br /&gt;&lt;strong&gt;Por favor, recuerde:&lt;/strong&gt; Seg����n los &lt;a href="javascript:void()" onclick="showpopup('/xwiki/bin/view/Main/TOS?xpage=popup'); return false;"&gt;T����rminos de Servicio&lt;/a&gt; de Curriki, usted tiene que tener al menos 13 a����os de edad para poder registrarse. Ninguna persona con menos de 13 a����os puede ser miembro de Curriki.

joincurriki.letsKnowWhoYouAre= Perm����tanos saber qui����n es usted
joincurriki.enterRequestedInfo= Introduzca toda la informaci����n solicitada si quiere hacerse un miembro con perfil p����blico. Los datos marcados con un signo de admiraci����n (!) son obligatorios.

joincurriki.enterPassword= Introduzca su contrase����a.
joincurriki.enterPasswordConfirm= Confirme su contrase����a.
joincurriki.enterValidEmail= Por favor, introduzca una direcci����n v����lida de correo electr����nico. Se enviar����n a esta direcci����n instrucciones para completar el proceso de registro.
joincurriki.ifApplicable= (si es preciso)
joincurriki.showContact= Esto permite a otros miembros de Curriki ver su informaci����n personal. 
joincurriki.fileds.age= Edad
joincurriki.iAm13YearsOld= Tengo al menos 13 a����os.
joincurriki.privacyAndTOS= Privacidad y t����rminos de uso.
joincurriki.privacyAndTOS.read.part1= He le����do, entendido, y estoy de acuerdo con 
joincurriki.privacyAndTOS.read.part2= y el
joincurriki.iAgree= Estoy de acuerdo
joincurriki.emailWillBeSent= Cuando haga click sobre Guardar y Registrar, Curriki le enviar���� un mensaje de confirmaci����n a la direcci����n de correo electr����nico escrita arriba

joincurriki.password.noSpaces= No se permiten espacios en la contrase����a.
joincurriki.password.tooShort= La contrase����a es demasiado corta.
joincurriki.password.noMatch= La contrase����a no coincide.
joincurriki.email.invalidFormat= El formato de la direcci����n de correo electr����nico es inv����lido.
joincurriki.someDataMissing= Faltan algunos datos; mire las ����reas destacadas.
joincurriki.email.alreadyUsed= Su direcci����n de correo electr����nico ya ha sido usada.
joincurriki.login.alreadyUsed= Su nombre de usuario ya ha sido usado.
joincurriki.saveMyInfoAndRegister= Guardar Informaci����n y Registrar
joincurriki.accountCreated= Su cuenta ha sido creada. Ya puede entrar.
joincurriki.chooseOptOut= No quiero recibir correo sobre formas de participaci����n en Curriki. 
joincurriki.topics= 

joincurriki.fields.xwikiname= Nombre de usuario
joincurriki.chooseYourCommunityName= Usar���� este nombre para acceder a su cuenta.
joincurriki.fields.age= Edad
joincurriki.fields.first_name= Nombre:
joincurriki.fields.last_name= Apellido:
joincurriki.fields.password= Contrase����a:
joincurriki.fields.password2= Contrase����a (repetici����n):
joincurriki.fields.email= Direcci����n de correo electr����nico:
joincurriki.fields.opt_out= No recibir correo electr����nico:
joincurriki.fields.topics= ����reas de inter����s:
joincurriki.fields.member_type= Tipo de miembro:
joincurriki.fields.country= Pa����s:
joincurriki.fields.state= Estado/provincia:
joincurriki.fields.city= Ciudad:
joincurriki.fields.affiliation= Organizaci����n de afiliaci����n:
joincurriki.fields.show_contact= Mostrar su perfil:

#XWiki.XWikiUserSheet

profile.edit= Editar perfil
profile.accessDenied= Debe estar registrado como miembro de Curriki para ver perfiles de miembros.
profile.userNotVisible= Este miembro prefiere no mostrar su perfil.
profile.removePhoto.confirmation= ����Seguro que quiere borrar su foto?
profile.removePhoto= Borrar foto
profile.removeYourPhoto= Borrar su foto
profile.modifyYourPhoto= Cambiar su foto
profile.changeMyPhoto= Cambiar mi foto
profile.changeMyPhoto.needToRemove= Antes tiene que borrar su foto. ����Seguro que quiere hacerlo?
profile.field.firstName= Nombre:
profile.field.lastName= Apellido:
profile.field.display.firstName= Nombre:
profile.field.display.lastName= Apellido:
profile.field.memberType= Tipo de miembro:
profile.field.affiliation= Organizaci����n de afiliaci����n:
profile.field.country= Pa����s:
profile.field.state= Estado/provincia:
profile.field.city= Ciudad:
profile.field.showContact= Permitir que los miembros de Curriki vean mi perfil:
profile.field.email= Direcci����n de correo electr����nico:
profile.field.opt_out= No recebir mensajes de correo electr����nico:
profile.field.opt_out.checkbox_text= No quiero recibir correo sobre c����mo participar en la comunidad de Curriki.
profile.field.password= Contrase����a:
profile.field.passwordConfirm= Confirmar contrase����a:
profile.field.topics= ����reas de inter����s:
profile.field.bio= Biograf����a:
profile.emptyField= &amp;ndash;

profile.chooseAPhoto= Escoja una fotograf����a:

profile.field.password.nospaces= No se permiten espacio en la contrase����a.
profile.field.password.tooShort= La contrase����a es demasiado corta.
profile.field.password.mustMatch= La contrase����a no coincide.
profile.field.firstName.mandatory= El nombre es un dato necesario.
profile.field.lastName.mandatory= El apellido es un dato necesario.
profile.field.email.mandatory= La direcci����n del correo electr����nico es un dato necesario.
profile.field.email.invalid= La direcci����n de correo electr����nica no es v����lida.

# Registration pages information
registration.email= webmaster@curriki.org
registration.validate.validated= ����Ya se ha completado el proceso de registro!&lt;br /&gt;
registration.login_button= OK
registration.validate.failed.bad_key_or_loginname= Lo siento, o el nombre de usuario o la clave de validaci����n es incorrecto. Por favor, vuelva a intentarlo.
registration.validate.failed.no_info= La informaci����n requerida no ha sido aceptada.

# Registration.EmailNotReceived
email_not_received.title= Direcci����n de correo electr����nico no recibida
email_not_received.info= Por favor, rellene la informaci����n solicitada a continuaci����n, cuando haya acabado pulse ENVIAR.
email_not_received.required= Los datos marcados con un signo de exclamaci����n (!) son necesarios.
email_not_received.login= Nombre de usuario:
email_not_received.email= Direcci����n de correo electr����nico:
email_not_received.phone= N����mero de tel����fono:
email_not_received.client= Cliente de correo electr����nico (por ejemplo, Outlook)
email_not_received.button= ENVIAR
email_not_received.missing= Por favor, rellene todos los datos necesarios.
email_not_received.error.need_login= Por favor, introduzca un nombre de usuario
email_not_received.error.need_email= Por favor, introduzca su direcci����n de correo electr����nico
email_not_received.error.need_phone= Por favor, introduzca su n����mero de tel����fono

email_not_received.email_sent= Gracias por ponerse en contacto con Curriki. Un representante se podr���� en contacto con usted.&lt;br /&gt;&lt;br /&gt;&lt;a href="/xwiki/bin/view/Main/" class="button button-orange"&gt;OK&lt;/a&gt;
email_not_received_sent.title= Enviado mensaje de correo no recibido

#Header
loginUsername= nombre de usuario

#Enter Login Name Again
username= Nombre de usuario

## Email Validation
emailValidation.step1.errNoUser= No se ha proporcionado un nombre de usuario.
emailValidation.step1.errNotFound= Usuario no encontrado.
emailValidation.step1.errNotBounced= El correo no est���� rebotando.
emailValidation.step1.errNoEmail= Por favor, introduzca una direcci����n de correo electr����nico.
emailValidation.step1.errBadEmail= Por favor, introduzca una direcci����n v����lida de correo electr����nico.
emailValidation.step1.errDupEmail= Esa direcci����n de correo electr����nico est���� siendo usada por otro usuario.

emailValidation.step1.title= Comprobaci����n de correo - Paso 1 de 2
emailValidation.step1.intro= La seguridad de nuestros miembros es la m����xima preocupaci����n de Curriki. Para mantener la seguridad, Curriki comprueba todas las direcciones de correo electr����nico.
emailValidation.step1.weHave= Para {0} {1} nuestro registros muestran {2}.
emailValidation.step1.pleaseSubmit= Apriete el bot����n Enviar para enviar un mensaje de comprobaci����n a esta direcci����n. O modifique su direcci����n de correo electr����nico (su perfil se actualizar���� autom����ticamente) y entonces apriete Enviar.
emailValidation.step1.submit= Enviar

emailValidation.step1.goElsewhere= Cualquier cambio hecho en la p����gina se perder����. Seleccione OK para terminar la sesi����n y volver a la p����gina inicial. Podr���� volver a este formulario al entrar en su cuenta. Seleccione Cancelar para volver al formulario y enviar sus cambios.

emailValidation.sent.title= Mensaje de verificaci����n enviado
emailValidation.sent.text= &lt;p&gt;Se ha completado el primer paso de verificaci����n de su direcci����n de correo electr����nico. &lt;/p&gt;&lt;p&gt;Para completar el segundo paso, compruebe por favor si ha llegado a su bandeja de entrada un mensaje de webmaster@curriki.org&lt;/p&gt;&lt;p&gt;Si no ve este correo, puede ser debido a su filtro anti-spam. Mire tambi����n en su carpeta de spam, y aseg����rese de a����adir curriki.org a su lista o agenda de "remitentes seguros".&lt;/p&gt; 
emailValidation.sent.notreceived= Si no ha recibido un mensaje dentro de 10 minutos, por favor, p����ngase en contacto con Curriki usando el formulario de &lt;a href="/xwiki/bin/view/Registration/EmailNotReceived"&gt;Email no recibido&lt;/a&gt;.

emailValidation.step2.title= Correo electr����nico verificado - Paso 2 de 2 completado.
emailValidation.step2.text= &lt;p&gt;Su direcci����n de correo electr����nico ha sido confirmada.&lt;/p&gt;&lt;p&gt;Gracias.&lt;/p&gt;
emailValidation.step2.ok= OK

emailValidation.step2.errNoUser= Usuario inv����lido.
emailValidation.step2.errNoVkey= Clave inv����lida.
emailValidation.step2.errBadVkey= Clave inv����lida.
emailValidation.step2.errNotFound= Usuario no encontrado.
emailValidation.step2.errNotBounced= El correo no est���� rebotando.

staf.dialog.title= Enviar a un amigo
staf.dialog.recipients= Direccion(es) de correo electr����nico de el(los) destinatario(s):
staf.dialog.recipients.comments= Separe las direcciones de correo electr����nico con comas.
staf.dialog.customize= Personalizar mensaje (opcional):
staf.dialog.customize.default= Aqu���� hay un recurso estupendo que he encontrado en Curriki (una comunidad global de educaci����n y aprendizaje) que creo que te va a gustar.
staf.dialog.yourname= Tu nombre:
staf.dialog.ccme= Env����ame una copia
staf.dialog.youremail= Tu direcci����n de correo electr����nico:
staf.dialog.privacy= Tu direcci����n de correo electr����nico se usa para indicarle a tus amigos qui����n les env����a este mensaje. Las direcciones de correo electr����nico de sus amigos se usar����n ����nicamente para enviar este mensaje, y no ser����n guardadas en ning����n sitio. Si tiene dudas, lea por favor la &lt;a href="/xwiki/bin/view/Main/PrivacyPolicy"&gt;Pol����tica de Privacidad&lt;/a&gt; para conocer m����s detalles.
staf.dialog.cancel= Cancelar
staf.dialog.send= Enviar
staf.dialog.shouldcancel= La informaci����n introducida se perder����. ����Seguro que quiere salir? 

staf.from= sendtoafriend@curriki.org

staf.sent.okaymsg= Mensaje enviado.
staf.err.emptyto= Por favor, introduzca una direcci����n electr����nica.
staf.err.invalidemail= Por favor, introduzca una direcci����n v����lida de correo electr����nico.
staf.err.isguest= S����lo los miembros de Curriki pueden enviar recursos a amigos. Por favor, entre en su cuenta o h����gase miembro.
staf.sent.errored= Se ha producido un error desconocido.

##AFFILIATE REGISTRATION ERROR MESSAGES
partnerrigestration.validkey.invalid= No hemos podido validar la clave de su socio. 

partnerrigestration.parnter.notexist= El socio afiliado no aparece en nuestra base de datos. Por favor, contacte con el webmaster.
</content></xwikidoc>