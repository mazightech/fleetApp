$('document').ready(function () {

    //Edit invoiceStatus
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get invoiceStatus elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (invoiceStatus, status) {
            $('#id-edit').val(invoiceStatus.id);
            $('#description-edit').val(invoiceStatus.description);
            $('#details-edit').val(invoiceStatus.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details invoiceStatus
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get invoiceStatus elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (invoiceStatus, status) {
            $('#id-details').val(invoiceStatus.id);
            $('#description-details').val(invoiceStatus.description);
            $('#details-details').val(invoiceStatus.details);
            $('#lastModifiedBy-details').val(invoiceStatus.lastModifiedBy);
            $('#lastModifiedDate-details').val(invoiceStatus.lastModifiedDate.substr(0,19).replace("T"," "));
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