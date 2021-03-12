$('document').ready(function () {

    //Edit vehicleMovement
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMovement elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMovement, status) {
            $('#id-edit').val(vehicleMovement.id);
            $('#ddlVehicleEdit').val(vehicleMovement.vehicleid);
            var startDate = vehicleMovement.date1.substr(0,10);
            $('#date1-edit').val(startDate);
            var endDate = vehicleMovement.date2.substr(0,10);
            $('#date2-edit').val(endDate);
            $('#ddlLocation1Edit').val(vehicleMovement.locationid1);
            $('#ddlLocation2Edit').val(vehicleMovement.locationid2);
            $('#remarks-edit').val(vehicleMovement.remarks);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleMovement
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMovement elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMovement, status) {
            $('#id-detail').val(vehicleMovement.id);
            $('#ddlVehicleDetail').val(vehicleMovement.vehicleid);
            var startDate = vehicleMovement.date1.substr(0,10);
            $('#date1-detail').val(startDate);
            var endDate = vehicleMovement.date2.substr(0,10);
            $('#date2-detail').val(endDate);
            $('#ddlLocation1Detail').val(vehicleMovement.locationid1);
            $('#ddlLocation2Detail').val(vehicleMovement.locationid2);
            $('#remarks-detail').val(vehicleMovement.remarks);
            $('#lastModifiedBy-details').val(vehicleMovement.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleMovement.lastModifiedDate.substr(0,19).replace("T"," "));
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