# Ti.DRau


Axways Titanium module for communicating with AudioServer of Deutschlandfunk Köln.


## Constants
* STATION_DLF
* STATION_KULTUR
* STATION_NOVA

The requesting proceeds in pages. You can set the size with:

```javascript
const DRau = require('tidrau');
DRau.setPagesize(100);
```
Default is 500


## Aodlistaudio

The client gets JSON data from server.

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistaudio();
```

### Builder methods of client

You can filter the the request with the methods below:

#### setFrom()

Type is string. In form of `dd.mm.yyyy`

#### setTo()

Type is string. In form of `dd.mm.yyyy`

#### setSearchWord()

Type is string.

#### setLimit()

Type is integer.


#### setStation()

You can use the contants above

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistaudio();
drauClient.setStation(DRau.STATION_NOVA);
```
 
In the end you can call the method `get`. The result comes back by observer pattern:

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistaudio();
drauClient.addEventListener('load',onLoad);
drauClient
	.setStation(DRau.STATION_NOVA);
	.setFrom('01.01.2020'),
	.setLimit(200),
	.setSearchWord('klima')
	.get();
```

## Aodlistbroadcasts

#### setLimit()

Type is integer.


#### setStation()

You can use the contants above

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistaudio();
drauClient.setStation(DRau.STATION_NOVA);
```
 
In the end you can call the method `get`. The result comes back by observer pattern:

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistbroadcasts();
drauClient.addEventListener('load',onLoad);
drauClient
	.setStation(DRau.STATION_NOVA);
	.setLimit(200),
	.get();
```

