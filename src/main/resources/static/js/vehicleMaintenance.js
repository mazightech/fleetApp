$('document').ready(function () {

    //Edit vehicleMaintenance
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMaintenance elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance, status) {
            $('#id-edit').val(vehicleMaintenance.id);
            $('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);
            var startDate = vehicleMaintenance.startDate.substr(0,10);
            $('#startDate-edit').val(startDate);
            var endDate = vehicleMaintenance.endDate.substr(0,10);
            $('#endDate-edit').val(endDate);
            $('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);
            $('#price-edit').val(vehicleMaintenance.price);
            $('#remarks-edit').val(vehicleMaintenance.remarks);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicleMaintenance
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicleMaintenance elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance, status) {
            $('#id-detail').val(vehicleMaintenance.id);
            $('#ddlVehicleDetail').val(vehicleMaintenance.vehicleid);
            var startDate = vehicleMaintenance.startDate.substr(0,10);
            $('#startDate-detail').val(startDate);
            var endDate = vehicleMaintenance.endDate.substr(0,10);
            $('#endDate-detail').val(endDate);
            $('#ddlSupplierDetail').val(vehicleMaintenance.supplierid);
            $('#price-detail').val(vehicleMaintenance.price);
            $('#remarks-detail').val(vehicleMaintenance.remarks);
            $('#lastModifiedBy-details').val(vehicleMaintenance.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicleMaintenance.lastModifiedDate.substr(0,19).replace("T"," "));
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