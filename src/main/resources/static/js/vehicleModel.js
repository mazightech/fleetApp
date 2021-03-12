$('document').ready(function () {

    //Edit vehicleModel
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleModel elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleModel, status) {
            $('#id-edit').val(vehicleModel.id);
            $('#description-edit').val(vehicleModel.description);
            $('#details-edit').val(vehicleModel.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleModel
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleModel elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleModel, status) {
            $('#id-details').val(vehicleModel.id);
            $('#description-details').val(vehicleModel.description);
            $('#details-details').val(vehicleModel.details);
            $('#createdBy-details').val(vehicleModel.createdBy);
            if(vehicleModel.createdOn != null)
            $('#createdOn-details').val(vehicleModel.createdOn.substr(0,19).replace("T"," "));
            $('#lastModifiedBy-details').val(vehicleModel.lastModifiedBy);
            if(vehicleModel.lastModifiedOn != null)
            $('#lastModifiedOn-details').val(vehicleModel.lastModifiedOn.substr(0,19).replace("T"," "));
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