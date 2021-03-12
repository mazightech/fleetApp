$('document').ready(function () {

    //Edit invoice
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get invoice elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (invoice, status) {
            $('#id-edit').val(invoice.id);
            $('#ddlClientEdit').val(invoice.clientId);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDate-edit').val(invoiceDate);
            $('#ddlStateEdit').val(invoice.invoicestatusid);
            $('#code-edit').val(invoice.code);
            $('#remarks-edit').val(invoice.remarks);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details invoice
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get invoice elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (invoice, status) {
            $('#id-details').val(invoice.id);
            $('#ddlClientDetail').val(invoice.clientId);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDate-detail').val(invoiceDate);
            $('#ddlStateDetails').val(invoice.invoicestatusid);
            $('#code-details').val(invoice.code);
            $('#remarks-detail').val(invoice.remarks);
            $('#lastModifiedBy-details').val(invoice.lastModifiedBy);
            $('#lastModifiedDate-details').val(invoice.lastModifiedDate.substr(0,19).replace("T"," "));
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