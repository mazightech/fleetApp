$('document').ready(function () {

    //Edit vehicleStatus
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleStatus elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleStatus, status) {
            $('#id-edit').val(vehicleStatus.id);
            $('#description-edit').val(vehicleStatus.description);
            $('#details-edit').val(vehicleStatus.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleStatus
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleStatus elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleStatus, status) {
            $('#id-details').val(vehicleStatus.id);
            $('#description-details').val(vehicleStatus.description);
            $('#details-details').val(vehicleStatus.details);
            $('#lastModifiedBy-details').val(vehicleStatus.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleStatus.lastModifiedDate.substr(0,19).replace("T"," "));
        });
        // show edit modal
        $('#detailsModal').modal();
    });

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();

        // pass delete link from  href html to href of modal
        var href = $(this).attr('href');
        $('#confirmdelete').attr('href', href);

        //show delete pop modal
        $('#deleteModal').modal();
    });

});