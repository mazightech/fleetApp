$('document').ready(function () {

    //Edit employeeType
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get employeeType elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (employeeType, status) {
            $('#id-edit').val(employeeType.id);
            $('#description-edit').val(employeeType.description);
            $('#details-edit').val(employeeType.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details employeeType
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get employeeType elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (employeeType, status) {
            $('#id-details').val(employeeType.id);
            $('#description-details').val(employeeType.description);
            $('#details-details').val(employeeType.details);
            $('#lastModifiedBy-details').val(employeeType.lastModifiedBy);
            $('#lastModifiedDate-details').val(employeeType.lastModifiedDate.substr(0,19).replace("T"," "));
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