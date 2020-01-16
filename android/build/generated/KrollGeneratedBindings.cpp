/**
 * Axway Appcelerator Titanium Mobile
 * Copyright (c) 2017 by Axway. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
#include <unordered_map>
#include <KrollBindings.h>

#include "ti.aod.ListbroadcastsProxy.h"
#include "ti.aod.AodModule.h"
#include "ti.aod.ListaudioProxy.h"
#include "ti.aod.PreviewdataProxy.h"


namespace titanium {
	namespace bindings {

		struct BindEntry;
		
		struct Hash {
			// FNV-1a hashing algorithm
			// http://www.isthe.com/chongo/tech/comp/fnv/index.html#FNV-1a
			std::size_t operator()(const char* name) const {
				std::size_t length = strlen(name);
				std::size_t hash = 0x811C9DC5;
				for (std::size_t i = 0; i < length; ++i) {
					hash ^= name[i];
					hash += (hash << 24) + (hash << 8) + (hash << 7) + (hash << 4) + (hash << 1);
				}
				return hash;
			}
		};

		struct Compare {
			bool operator()(const char* a, const char* b) const {
				return !strcmp(a, b);
			}
		};

		class AodBindings {
			public:
				static BindEntry* lookupGeneratedInit(const char*, unsigned int);
		};

		BindEntry* AodBindings::lookupGeneratedInit(const char* name, unsigned int length) {
			static BindEntry binds[] = {
				{"ti.aod.PreviewdataProxy", ::ti::aod::aod::PreviewdataProxy::bindProxy, ::ti::aod::aod::PreviewdataProxy::dispose},
				{"ti.aod.ListaudioProxy", ::ti::aod::aod::ListaudioProxy::bindProxy, ::ti::aod::aod::ListaudioProxy::dispose},
				{"ti.aod.AodModule", ::ti::aod::AodModule::bindProxy, ::ti::aod::AodModule::dispose},
				{"ti.aod.ListbroadcastsProxy", ::ti::aod::aod::ListbroadcastsProxy::bindProxy, ::ti::aod::aod::ListbroadcastsProxy::dispose}
			};
			static std::unordered_map<const char*, BindEntry&, Hash, Compare> map = {
				{binds[0].name, binds[0]},
				{binds[1].name, binds[1]},
				{binds[2].name, binds[2]},
				{binds[3].name, binds[3]},
			};

			auto result = map.find(name);
			while (result != map.end()) {
				// fallback in case of very unlikely collision
				if (!strcmp(name, result->second.name)) {
					return &result->second;
				}
				result++;
			}
			return nullptr;
		}
	}
}