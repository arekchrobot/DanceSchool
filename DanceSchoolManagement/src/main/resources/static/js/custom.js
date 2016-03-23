$('a.menu-item').click(function () {
    $('li.active').removeClass('active');
    $('li.dropdown').removeClass('active');
    $(this).parent().addClass('active');
});
$('a.dropdown-item').click(function () {
    $('li.active').removeClass('active');
    $('li.dropdown').addClass('active');
});
$('a.navbar-brand').click(function () {
    $('li.active').removeClass('active');
    $('li.dropdown').removeClass('active');
});

// Hide the toTop button when the page loads.
$("#toTop").css("display", "none");

// This function runs every time the user scrolls the page.
$(window).scroll(function () {

    // Check weather the user has scrolled down (if "scrollTop()"" is more than 0)
    if ($(window).scrollTop() > 50) {

        // If it's more than or equal to 0, show the toTop button.
        console.log("is more");
        $("#toTop").fadeIn("slow");

    }
    else {
        // If it's less than 0 (at the top), hide the toTop button.
        console.log("is less");
        $("#toTop").fadeOut("slow");
    }
});
