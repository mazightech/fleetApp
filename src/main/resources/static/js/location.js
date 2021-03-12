$('document').ready(function () {

    //Edit location
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get location elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (location, status) {
            $('#id-edit').val(location.id);
            $('#ddlCountryEdit').val(location.countryid);
            $('#ddlStateEdit').val(location.stateid);
            $('#description-edit').val(location.description);
            $('#city-edit').val(location.city);
            $('#address-edit').val(location.address);
            $('#details-edit').val(location.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details location
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get location elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (location, status) {
            $('#id-details').val(location.id);
            $('#ddlCountryDetails').val(location.countryid);
            $('#ddlStateDetails').val(location.stateid);
            $('#description-details').val(location.description);
            $('#city-details').val(location.city);
            $('#address-details').val(location.address);
            $('#details-details').val(location.details);
            $('#lastModifiedBy-details').val(location.lastModifiedBy);
            $('#lastModifiedDate-details').val(location.lastModifiedDate.substr(0,19).replace("T"," "));
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