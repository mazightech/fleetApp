$('document').ready(function () {

    //Edit state
    $('table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get state elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#id-edit').val(state.id);
            $('#ddlCountryEdit').val(state.countryid);
            $('#name-edit').val(state.name);
            $('#capital-edit').val(state.capital);
            $('#code-edit').val(state.code);
            $('#details-edit').val(state.details);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details state
    $('table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get state elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (state, status) {
            $('#id-details').val(state.id);
            $('#ddlCountryDetails').val(state.countryid);
            $('#name-details').val(state.name);
            $('#capital-details').val(state.capital);
            $('#code-details').val(state.code);
            $('#details-details').val(state.details);
            $('#lastModifiedBy-details').val(state.lastModifiedBy);
            $('#lastModifiedDate-details').val(state.lastModifiedDate.substr(0,19).replace("T"," "));
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