module.exports = {
  airplane: function(successCallback) {
    cordova.exec(successCallback,
                 null, // No failure callback
                 "Airplane",
                 "airplane");
  }
};