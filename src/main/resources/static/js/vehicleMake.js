$('document').ready(function () {

    //Edit vehicleMake
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMake elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMake, status) {
            $('#id-edit').val(vehicleMake.id);
            $('#description-edit').val(vehicleMake.description);
            $('#details-edit').val(vehicleMake.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleMake
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMake elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMake, status) {
            $('#id-details').val(vehicleMake.id);
            $('#description-details').val(vehicleMake.description);
            $('#details-details').val(vehicleMake.details);
            $('#lastModifiedBy-details').val(vehicleMake.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleMake.lastModifiedDate.substr(0,19).replace("T"," "));
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