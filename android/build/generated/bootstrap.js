/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("ti.aod.AodModule")["Aod"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "Aod";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

	addInvocationAPI(module, "Aod", "Aod", "createListaudio");addInvocationAPI(module, "Aod", "Aod", "createListbroadcasts");addInvocationAPI(module, "Aod", "Aod", "createPreviewdata");
		if (!("__propertiesDefined__" in module)) {Object.defineProperties(module, {
"Listbroadcasts": {
get: function() {
var Listbroadcasts =  lazyGet(this, "ti.aod.ListbroadcastsProxy", "Listbroadcasts", "Listbroadcasts");
return Listbroadcasts;
},
configurable: true
},
"Listaudio": {
get: function() {
var Listaudio =  lazyGet(this, "ti.aod.ListaudioProxy", "Listaudio", "Listaudio");
return Listaudio;
},
configurable: true
},
"Previewdata": {
get: function() {
var Previewdata =  lazyGet(this, "ti.aod.PreviewdataProxy", "Previewdata", "Previewdata");
return Previewdata;
},
configurable: true
},

});
module.constructor.prototype.createListaudio = function() {
return new module["Listaudio"](arguments);
}
module.constructor.prototype.createListbroadcasts = function() {
return new module["Listbroadcasts"](arguments);
}
module.constructor.prototype.createPreviewdata = function() {
return new module["Previewdata"](arguments);
}
}
module.__propertiesDefined__ = true;
return module;

}
exports.bootstrap = moduleBootstrap;
