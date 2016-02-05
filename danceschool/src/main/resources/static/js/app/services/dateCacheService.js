appServices.service('dateCacheService', function() {
    
    var cacheTimeMin = 5;
    var shouldSynchronize = function(lastSynchronizationDate) {
        if(!lastSynchronizationDate) {
            var currentDate = new Date();

            var millisecondsDiff = currentDate - lastSynchronizationDate;
            var minutesDiff = millisecondsDiff/(1000*60);

            return minutesDiff >= cacheTimeMin;
        }
        return true;
    };
    
    return {
        shouldSynchronize : shouldSynchronize
    };
});