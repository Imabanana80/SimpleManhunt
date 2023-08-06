# SimpleManhunt
A super simple minecraft manhunt plugin

### Commands
| Command | Usage/Description |
|-|-| 
|`/runner`|View who the runner currently is|
| `/setrunner` | Set the runner|
|`/hunters`| View who the hunters currently are|
|`/addhunter`| Add a hunter|
|`/removehunter`| Remove a hunter|
|`/tracker`| Give yourself a tracker|

### Configuration
You do not need to manually configure hunters and runners in the config.yml. Just use the above-mentioned commands.

### Something to note
When running /reload (or restarting the server), the plugin will no longer have the runner's portals saved, which means that it may cause issues if the runner is in the nether or end or the tracker is in the nether.