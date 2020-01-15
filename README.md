# Ti.Oad


Axways Titanium module for communicating with AudioServer of Deutschlandfunk Köln.


## Constants
* STATION_DLF
* STATION_KULTUR
* STATION_NOVA

The requesting proceeds in pages. You can set the size with:

```javascript
const Oad = require('ti.oad');
Oad.setPagesize(100);
```
Default is 500


## Listaudio

The client gets JSON data from server.

```javascript
const Oad = require('ti.oad');
const oadClient = Oad.createListaudio();
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
const Oad = require('ti.oad');
const OadClient = Oad.createListaudio();
OadClient.setStation(Oad.STATION_NOVA);
```
 
In the end you can call the method `get`. The result comes back by observer pattern:

```javascript
const Oad = require('ti.oad');
const OadClient = Oad.createAodlistaudio();
OadClient.addEventListener('load',onLoad);
OadClient
	.setStation(Oad.STATION_NOVA);
	.setFrom('01.01.2020'),
	.setLimit(200),
	.setSearchWord('klima')
	.get();
```

## Listbroadcasts

This method retreives all broadcasts (sendungen).


The constructor has three properties:

#### limit

Type is integer.


#### station

You can use the contants above

```javascript
const Oad = require('ti.oad');
const OadClient = Oad.createAodlistaudio();
OadClient.setStation(Oad.STATION_NOVA);
```

#### onload

```javascript
const Oad = require('ti.oad');
const OadClient = Oad.createAodlistbroadcasts({
	station : Oad.STATION_NOVA,
	onload : (e) => comsole.log(e)
});
```

## Previewdata

This gives you the actual details about transmission


The constructor has two properties:


#### station

You can use the contants above



#### interval

In ms

```javascript
const Oad = require('ti.oad');
const OadClient = Oad.createListbroadcasts({
	station : Oad.STATION_NOVA,
});
```

### Methods

#### start()
##### interval
##### onload

```javascript
```javascript
const Oad = require('tiOad');
const OadPreview = Oad.createPreviewdata({
	station:  Oad.STATION_KULTUR
});
OadPreview.start({
	interval : 5000,
	onload : e => console.log(e)
});

```
 

#### stop()


further endpoints:
https://srv.deutschlandradio.de/aodradionightdata.1860.de.rpc




