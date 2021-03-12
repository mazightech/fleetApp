$('document').ready(function () {

    //Edit jobTitle
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get jobTitle elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (jobTitle, status) {
            $('#id-edit').val(jobTitle.id);
            $('#description-edit').val(jobTitle.description);
            $('#details-edit').val(jobTitle.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details jobTitle
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get jobTitle elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (jobTitle, status) {
            $('#id-details').val(jobTitle.id);
            $('#description-details').val(jobTitle.description);
            $('#details-details').val(jobTitle.details);
            $('#lastModifiedBy-details').val(jobTitle.lastModifiedBy);
            $('#lastModifiedDate-details').val(jobTitle.lastModifiedDate.substr(0,19).replace("T"," "));
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