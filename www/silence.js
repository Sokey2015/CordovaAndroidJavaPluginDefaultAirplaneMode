module.exports = {
  airplane: function(successCallback) {
    cordova.exec(successCallback,
                 null, // No failure callback
                 "Silence",
                 "toggleAirplane");
  }

ringer: function(successCallback) {
    cordova.exec(successCallback,
                 null, // No failure callback
                 "Silence",
                 "toggleRinger");
  }

  notifications: function(successCallback) {
    cordova.exec(successCallback,
                 null, // No failure callback
                 "Silence",
                 "toggleNotifications");
  }

};