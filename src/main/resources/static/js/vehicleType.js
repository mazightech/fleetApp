$('document').ready(function () {

    //Edit vehicleType
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleType elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleType, status) {
            $('#id-edit').val(vehicleType.id);
            $('#description-edit').val(vehicleType.description);
            $('#details-edit').val(vehicleType.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleType
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleType elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleType, status) {
            $('#id-details').val(vehicleType.id);
            $('#description-details').val(vehicleType.description);
            $('#details-details').val(vehicleType.details);
            $('#lastModifiedBy-details').val(vehicleType.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleType.lastModifiedDate.substr(0,19).replace("T"," "));
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