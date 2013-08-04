$(document).ready(function() {
 
 
 
/* see if anything is previously checked and reflect that in the view*/
$(".checklist input:checked").parent().addClass("selected");
$(".checklist-remove input:checked").parent().addClass("selected");

/* handle the user selections */
$(".checklist .checkbox-select").click(
function(event) {
event.preventDefault();
$(this).parent().addClass("selected");
$(this).parent().find(":checkbox").attr("checked","checked");
 
}
);

$(".checklist-remove .checkbox-remove").click(
function(event) {
event.preventDefault();
$(this).parent().addClass("selected");
$(this).parent().find(":checkbox").attr("checked","checked");
 
}
);

 
$(".checklist .checkbox-deselect").click(
function(event) {
event.preventDefault();
$(this).parent().removeClass("selected");
$(this).parent().find(":checkbox").removeAttr("checked");
 
}
);
 
$(".checklist-remove .checkbox-remove-deselect").click(
function(event) {
event.preventDefault();
$(this).parent().removeClass("selected");
$(this).parent().find(":checkbox").removeAttr("checked");
 
}
); 
 
});