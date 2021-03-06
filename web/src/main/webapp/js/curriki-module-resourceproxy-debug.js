function postMessageHandler(event){ // Event having data of the form "eventtype:value"
	var eventData = event.data;
	var eventType = eventData.substr(0,eventData.indexOf(":")); // Get the "eventtype"
	var value = eventData.substr(eventData.indexOf(":")+1); // Get the "value"
	switch(eventType){
		case 'resize':
			console.log("resource display: recieved resize event");
			resizeCurrikiIframe(value);
		break
	}
}

function resizeCurrikiIframe(styleString){
  document.getElementById("curriki_resource_frame").setAttribute("style", styleString)
}

if(typeof window.attachEvent === "function" || typeof window.attachEvent === "object"){ // Firefox 
	console.log("search: attached Listener to evenet via window.attachEvent");
	window.attachEvent('onmessage',postMessageHandler);
}else if (typeof window.addEventListener === "function"){
	console.log("search: attached Listener to evenet via window.addEvenListener");
  	window.addEventListener("message", postMessageHandler, false);
}else if(typeof document.attachEvent === "function"){
	console.log("search: cors iframe communication is not possible");
	document.attachEvent('onmessage',postMessageHandler);
}else{
	console.log("Frame communication not possible");
}
// vim: ts=4:sw=4
/*global Ext */
/*global _ */

(function(){
	Ext.ns('Curriki.module.resourceproxy');

	var ResourceProxy = Curriki.module.resourceproxy;

	ResourceProxy.settings = {
		proxyUrl: "http://current.dev.curriki.org" //Working on current util release
	};

	ResourceProxy.run = function(){
		console.log("resourceproxy: starting");
		var url = ResourceProxy.getResourceUrlFromParams();

		ResourceProxy.renderPage(url);
	};

	ResourceProxy.getResourceUrlFromParams = function(){
		var params = Ext.urlDecode(location.search.substring(1));

		if(! (typeof params.resourceurl === "undefined") ){
			return params.resourceurl;
		} else {
			document.write("Please provide a resource to display");
			throw "EmbeddedDisplay Error: No ressourceurl defined";
		}
	};

	ResourceProxy.renderPage = function(url){
		var resourceFrame = document.getElementById("curriki_resource_frame");
		resourceFrame.setAttribute("src", ResourceProxy.settings.proxyUrl + unescape(url));
	};

	Ext.onReady(function(){
		ResourceProxy.run();
	});

})();
