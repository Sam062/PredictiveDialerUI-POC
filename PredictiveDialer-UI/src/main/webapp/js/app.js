
$(document).ready(function () {
    $('#fileupload').hide();
    document.getElementById('resetButton').click();
    $('#dialerTab').DataTable({
        "pagingType": "full_numbers",
        //you can see only Previous and Next buttons are displaying, we can customize our table to display First Previous Next Last buttons

        //"pageLength": 6 // used to display rows per page

        "lengthMenu": [[6, 10, 25, 50, -1], [6, 10, 25, 50, "All"]]
        // used to manupulate the dropdown 
    });


    $('#importbutton').click(function () {
        $('#importspan').css("margin-left", "31rem");
        $('#fileupload').show();

        let x = document.getElementById('fileupload').value.split('.');
        // alert(x.length);
        // alert(x);
        if (x.length > 1) {
            if (x[1] != 'csv')
                alert('FILE IS NOT CSV');
        }

    });

});

function hideImportButton() {
    document.getElementById('resetButton').click();
    $('#fileupload').hide();
    $('#importspan').css("margin-left", "51rem");
}

function callerInfo(name, email, mobile1, mobile2, zip, priority, status) {
    alert('USER DETAILS');
}
function dial(number) {
    alert('Dialing...' + number);

    $.ajax({
        url: 'http://localhost:9695/handledial?name=' + name,
        type: "GET",
        crossDomain: true,
        success: function (response) {
            alert("Success Response :: " + response);
        }, failure: function (response) {
            alert("Failure Response :: " + response);
        }
    });
}
function hangup(number) {
    alert('Hanging Up...' + number);

    $.ajax({
        url: 'http://localhost:9695/hangup?name=' + name,
        type: "GET",
        crossDomain: true,
        success: function (response) {
            alert("Success Response :: " + response);
        }, failure: function (response) {
            alert("Failure Response :: " + response);
        }
    });
}


