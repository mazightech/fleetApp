$('document').ready(function () {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get client elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (client, status) {
            $('#id-edit').val(client.id);
            $('#address-edit').val(client.address);
            $('#city-edit').val(client.city);
            $('#ddlCountryEdit').val(client.countryid);
            $('#email-edit').val(client.email);
            $('#details-edit').val(client.details);
            $('#mobile-edit').val(client.mobile);
            $('#name-edit').val(client.name);
            $('#phone-edit').val(client.phone);
            $('#ddlStateEdit').val(client.stateid);
            $('#website-edit').val(client.website);
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