appServices.service('dateCacheService', function() {
    
    var shouldSynchronize = function(lastSynchronizationDate, cacheTimeMin) {
        if(lastSynchronizationDate != null) {
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