
var baseUrl = window.location.origin;

function test(token) {
    $.ajax({
        url:   baseUrl + '/r1',
        async: false,
        type: 'GET',
        contentType: "application/json",
        headers: {'Authorization': 'Bearer' + token},
        success: function (result) {
            console.log(result);
        }
    });
}