$(document).ready(function() {
        $('#newsNumber').blur(function(event) {
                var name = $('#newsNumber').val();
                $.get('NewsSelector', {
                        userName : name
                }, function(responseText) {
                        $('#ajaxResponse').text(responseText);
                });
        });
});
 