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

This method retreives all broadcasts (sender).


The constructor has three properties:

#### limit

Type is integer.


#### station

You can use the contants above

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistaudio();
drauClient.setStation(DRau.STATION_NOVA);
```

#### onload

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistbroadcasts({
	station : DRau.STATION_NOVA,
	onload : (e) => comsole.log(e)
});
```

## Aodpreviewdata

This gives you the actual details about transmission


The constructor has two properties:


#### station

You can use the contants above



#### interval

In ms

```javascript
const DRau = require('tidrau');
const drauClient = Drau.createAodlistbroadcasts({
	station : DRau.STATION_NOVA,
});
```

### Methods

#### start()
##### interval
##### onload

```javascript
```javascript
const DRau = require('tidrau');
const drauPreview = Drau.createAodpreviewdata({
	station:  DRau.STATION_KULTUR
});
drauPreview.start({
	interval : 5000,
	onload : e => consoe.log(e)
});

```
 

#### stop()



