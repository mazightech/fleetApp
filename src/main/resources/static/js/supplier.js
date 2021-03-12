$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get supplier elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (supplier, status) {
            $('#id-edit').val(supplier.id);
            $('#address-edit').val(supplier.address);
            $('#city-edit').val(supplier.city);
            $('#ddlCountryEdit').val(supplier.countryid);
            $('#email-edit').val(supplier.email);
            $('#details-edit').val(supplier.details);
            $('#mobile-edit').val(supplier.mobile);
            $('#name-edit').val(supplier.name);
            $('#phone-edit').val(supplier.phone);
            $('#ddlStateEdit').val(supplier.stateid);
            $('#website-edit').val(supplier.website);
         });
        // show edit modal
        $('#editModal').modal();
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