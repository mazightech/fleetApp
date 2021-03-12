$('document').ready(function () {

    //Edit vehicleHire
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleHire elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleHire, status) {
            $('#id-edit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);
            $('#ddlClientEdit').val(vehicleHire.clientid);
            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateOut-edit').val(dateOut);
            var dateIn = vehicleHire.dateIn.substr(0,10);
            $('#dateIn-edit').val(dateIn);
            $('#timeOut').val(vehicleHire.timeOut);
            $('#timeIn-edit').val(vehicleHire.timeIn);
            $('#ddlLocationEdit').val(vehicleHire.locationid);
            $('#price-edit').val(vehicleHire.price);
            $('#remarks-edit').val(vehicleHire.remarks);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleHire
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleHire elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleHire, status) {
            $('#ddlVehicleDetail').val(vehicleHire.vehicleid);
            $('#ddlClientDetail').val(vehicleHire.clientid);
            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateOut-detail').val(dateOut);
            var dateIn = vehicleHire.dateIn.substr(0,10);
            $('#dateIn-detail').val(dateIn);
            $('#timeOut').val(vehicleHire.timeOut);
            $('#timeIn-detail').val(vehicleHire.timeIn);
            $('#ddlLocationDetail').val(vehicleHire.locationid);
            $('#price-detail').val(vehicleHire.price);
            $('#remarks-detail').val(vehicleHire.remarks);
            $('#lastModifiedBy-details').val(vehicleHire.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleHire.lastModifiedDate.substr(0,19).replace("T"," "));
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