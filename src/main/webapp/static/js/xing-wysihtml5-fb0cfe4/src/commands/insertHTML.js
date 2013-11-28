(function(wysihtml5) {
  var undef;
  
  wysihtml5.commands.insertHTML = {
    exec: function(composer, command, html) {
      if (composer.commands.support(command)) {
        composer.doc.execCommand(command, 0, html);
      } else {
        composer.selection.insertHTML(html);
      }
    },

    state: function() {
      return 0;
    },

    value: function() {
      return undef;
    }
  };
})(wysihtml5);