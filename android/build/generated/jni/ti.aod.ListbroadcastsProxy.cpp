/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "ti.aod.ListbroadcastsProxy.h"

#include "AndroidUtil.h"
#include "JNIUtil.h"
#include "JSException.h"
#include "TypeConverter.h"
#include "V8Util.h"


#include "org.appcelerator.kroll.KrollProxy.h"

#define TAG "ListbroadcastsProxy"

using namespace v8;

namespace ti {
namespace aod {
	namespace aod {


Persistent<FunctionTemplate> ListbroadcastsProxy::proxyTemplate;
jclass ListbroadcastsProxy::javaClass = NULL;

ListbroadcastsProxy::ListbroadcastsProxy() : titanium::Proxy()
{
}

void ListbroadcastsProxy::bindProxy(Local<Object> exports, Local<Context> context)
{
	Isolate* isolate = context->GetIsolate();

	Local<FunctionTemplate> pt = getProxyTemplate(isolate);

	v8::TryCatch tryCatch(isolate);
	Local<Function> constructor;
	MaybeLocal<Function> maybeConstructor = pt->GetFunction(context);
	if (!maybeConstructor.ToLocal(&constructor)) {
		titanium::V8Util::fatalException(isolate, tryCatch);
		return;
	}

	Local<String> nameSymbol = NEW_SYMBOL(isolate, "Listbroadcasts"); // use symbol over string for efficiency
	exports->Set(context, nameSymbol, constructor);
}

void ListbroadcastsProxy::dispose(Isolate* isolate)
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Reset();
	}

	titanium::KrollProxy::dispose(isolate);
}

Local<FunctionTemplate> ListbroadcastsProxy::getProxyTemplate(v8::Isolate* isolate)
{
	Local<Context> context = isolate->GetCurrentContext();
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate.Get(isolate);
	}

	LOGD(TAG, "ListbroadcastsProxy::getProxyTemplate()");

	javaClass = titanium::JNIUtil::findClass("ti/aod/ListbroadcastsProxy");
	EscapableHandleScope scope(isolate);

	// use symbol over string for efficiency
	Local<String> nameSymbol = NEW_SYMBOL(isolate, "Listbroadcasts");

	Local<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(
		isolate,
		titanium::KrollProxy::getProxyTemplate(isolate),
		javaClass,
		nameSymbol);

	proxyTemplate.Reset(isolate, t);
	t->Set(titanium::Proxy::inheritSymbol.Get(isolate), FunctionTemplate::New(isolate, titanium::Proxy::inherit<ListbroadcastsProxy>));

	// Method bindings --------------------------------------------------------

	Local<ObjectTemplate> prototypeTemplate = t->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = t->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------

	// Dynamic properties -----------------------------------------------------

	// Accessors --------------------------------------------------------------
	Local<String> onLoad = NEW_SYMBOL(isolate, "onLoad");
	instanceTemplate->SetAccessor(
		onLoad,
		titanium::Proxy::getProperty,
		titanium::Proxy::onPropertyChanged);
	DEFINE_PROTOTYPE_METHOD_DATA(isolate, t, "getOnLoad", titanium::Proxy::getProperty, onLoad);
	DEFINE_PROTOTYPE_METHOD_DATA(isolate, t, "setOnLoad", titanium::Proxy::onPropertyChanged, onLoad);

	return scope.Escape(t);
}

Local<FunctionTemplate> ListbroadcastsProxy::getProxyTemplate(v8::Local<v8::Context> context)
{
	return getProxyTemplate(context->GetIsolate());
}

// Methods --------------------------------------------------------------------

// Dynamic property accessors -------------------------------------------------


	} // namespace aod
} // aod
} // ti
