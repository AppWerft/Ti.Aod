# Ti.Aod


Axways Titanium module for communicating with AudioServer of Deutschlandfunk Köln.

## startDailyScheduler()
This method starts the fetching of daily scheduler. 


## Constants
* STATION_DLF
* STATION_DRK
* STATION_NOVA

The requesting proceeds in pages. You can set the size with:

```javascript
const Aod= require('ti.aod');
Oad.setPagesize(100);
```
Default is 500


## Listaudio

The client gets JSON data from server.

```javascript
const Aod= require('ti.aod');
const aodClient = Aod.createListaudio();
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
const Aod= require('ti.aod');
const OadClient = Oad.createListaudio();
OadClient.setStation(Oad.STATION_NOVA);
```
 
In the end you can call the method `get`. The result comes back by observer pattern:

```javascript
const Aod= require('ti.aod');
const AodClient = Aod.createAodlistaudio();
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

You can use the constants above

```javascript
const Aod= require('ti.aod');
const AodList = Aod.createListaudio();
AoList.setStation(Oad.STATION_NOVA);
```

#### onload

```javascript
const Aod= require('ti.aod');
const AodLis = Aod.createListbroadcasts({
	station : Aod.STATION_NOVA,
	onlAod: (e) => console.log(e)
});
```

## Livedata

This gives you the actual details about transmission


The constructor has two properties:


#### station

You can use the contants above



#### interval

In ms


### Methods

#### start()
##### interval
##### onload

```javascript
```javascript
const Aod= require('tiOad');
const OadPreview = Oad.createLivedata({
	station:  Oad.STATION_KULTUR
});
OadPreview.start({
	interval : 5000,
	onload: e => console.log(e)
});

```
 

#### stop()


other endpoints:
https://srv.deutschlandradio.de/aodradionightdata.1860.de.rpc




