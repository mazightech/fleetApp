$('document').ready(function () {

    //Edit contact
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get contact elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (contact, status) {
            $('#id-edit').val(contact.id);
            $('#firstname-edit').val(contact.firstname);
            $('#lastname-edit').val(contact.lastname);
            $('#email-edit').val(contact.email);
            $('#mobile-edit').val(contact.mobile);
            $('#phone-edit').val(contact.phone);
            $('#remarks-edit').val(contact.remarks);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details contact
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get contact elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (contact, status) {
            $('#firstname-detail').val(contact.firstname);
            $('#lastname-detail').val(contact.lastname);
            $('#email-detail').val(contact.email);
            $('#mobile-detail').val(contact.mobile);
            $('#phone-detail').val(contact.phone);
            $('#remarks-detail').val(contact.remarks);
            $('#lastModifiedBy-details').val(contact.lastModifiedBy);
            $('#lastModifiedDate-details').val(contact.lastModifiedDate.substr(0,19).replace("T"," "));
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