$('a.menu-item').click(function () {
    $('li.active').removeClass('active');
    $(this).parent().addClass('active');
});