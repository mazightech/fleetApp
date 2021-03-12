$('document').ready(function () {

    //Edit vehicle
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicle elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicle, status) {
            $('#id-edit').val(vehicle.id);
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
            $('#name-edit').val(vehicle.name);
            $('#vehicleNumber-edit').val(vehicle.vehicleNumber);
            var registrationDate = vehicle.registrationDate.substr(0,10);
            $('#registrationDate-edit').val(registrationDate);
            $('#description-edit').val(vehicle.description);
            var acquisitionDate = vehicle.acquisitionDate.substr(0,10);
            $('#acquisitionDate-edit').val(acquisitionDate);
            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlCurrentLocationEdit').val(vehicle.locationid);
            $('#ddlPowerEdit').val(vehicle.power);
            $('#fuelCapacity-edit').val(vehicle.fuelCapacity);
            $('#netWeight-edit').val(vehicle.netWeight);
            $('#remarks-edit').val(vehicle.remarks);
            $('#ddlEmployeeEdit').val(vehicle.employeeid);
            $('#ddlCurrentStatusEdit').val(vehicle.vehiclestatusid);
            $('#fupImageEdit').val(vehicle.photo);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details vehicle
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get vehicle elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (vehicle, status) {
            $('#ddlVehicleTypeDetail').val(vehicle.vehicletypeid);
            $('#name-detail').val(vehicle.name);
            $('#vehicleNumber-detail').val(vehicle.vehicleNumber);
            var registrationDate = vehicle.registrationDate.substr(0,10);
            $('#registrationDate-detail').val(registrationDate);
            $('#description-detail').val(vehicle.description);
            var acquisitionDate = vehicle.acquisitionDate.substr(0,10);
            $('#acquisitionDate-detail').val(acquisitionDate);
            $('#ddlVehicleMakeDetail').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelDetail').val(vehicle.vehiclemodelid);
            $('#ddlCurrentLocationDetail').val(vehicle.locationid);
            $('#ddlPowerDetail').val(vehicle.power);
            $('#fuelCapacity-detail').val(vehicle.fuelCapacity);
            $('#netWeight-detail').val(vehicle.netWeight);
            $('#remarks-detail').val(vehicle.remarks);
            $('#ddlEmployeeDetail').val(vehicle.employeeid);
            $('#ddlCurrentStatusDetail').val(vehicle.vehiclestatusid);
            $('#fupImageDetail').val(vehicle.photo);
            $('#lastModifiedBy-details').val(vehicle.lastModifiedBy);
            $('#lastModifiedDate-details').val(vehicle.lastModifiedDate.substr(0,19).replace("T"," "));
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