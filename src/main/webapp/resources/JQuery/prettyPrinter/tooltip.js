 var lastSelected=null;
 var lastHover= null;
 var isWaiting= false;

 /*
Agrega la funcionalidad hover y click
*/
 $(document).ready(function() {
  	      	 
	$('.show-tooltip').hover(
		function() {
			this.ids=this.title;
			this.title='';
			if(!isWaiting)
			{
				showInfo(this);
			}    
		}
		,
		function() {
			this.title=this.ids;
			if(!isWaiting)
			{
				$(this.getAttribute("idParent")).removeClass("selectedDark");
			}
		}
	);
	$('.show-tooltip').click(
		function() {
			isWaiting=true;
			showInfo(this);
			setTimeout('setWaitingFalse()', 3000);
		}
	);
});

function setWaitingFalse()
{
	isWaiting=false;
}

/*
Hace el property panel Draggable 
*/
$(function() {
	$( "#floatingPanel" ).draggable({ handle: "#property-header", cursor: "move"});
	
	$( "#theme" ).change(function(){
		$("#themeLink").attr("href","css/"+$(this).val()+"/jquery-ui-1.9.1.custom.css");
	});
	
});

/*
Muestra la info en el Property Panel
*/
function showInfo(nodo)
{
				$(".selectedDark").removeClass("selectedDark");
				$(nodo.getAttribute("idParent")).addClass("selectedDark");
				if(lastHover!=null)
				{
					lastHover.removeClass("hover-text")
				}
				lastHover=$(nodo);
				$(nodo).addClass("hover-text");
				$('#propertyPanel').html($('#'+nodo.ids).html());
				$('#viewerPanel').html('');
				cargarBotones();
}


/*
Cuando se salta a un archivo externo selecciona y muestra la info
*/
$(document).ready(function() {
	var pathname = $(location).attr('href');
	var section='#'+pathname.split("#")[1];
	var html =$(section).html();

	if(pathname.split("#")[1] != undefined )
	{
		$('#viewerPanel').html("<div class=\"code-highlighter\">"+html+"</div>");
	}
	
	if(lastSelected!=null)
	{
		lastSelected.removeClass("selected")
	}
	lastSelected=$(section);
	$(section).addClass("selected");
	
	var info='#info'+section.split("#section")[1];
	$('#propertyPanel').html($(info).html());
	cargarBotones();
	
});



function cargarBotones(){
				$( ".goToInnerFile" ).click(function() {
					var html =$("#"+this.title).html();
					$('#viewerPanel').html("<div class=\"code-highlighter\">"+html+"</div>");
					if(lastSelected!=null)
					{
						lastSelected.removeClass("selected")
					}
					lastSelected=$("#"+this.title);
					$("#"+this.title).addClass("selected");
					document.location =this.getAttribute("href");
				});				
				$( ".goTo" ).click(function() {
					$('#viewerPanel').html($("#"+this.title).html());
					if(lastSelected!=null)
					{
						lastSelected.removeClass("selected")
					}
					lastSelected=$("#"+this.title);
					$("#"+this.title).addClass("selected");
					window.open(this.getAttribute("href"),this.getAttribute("target"));
				});
				var searchButtonWasPressed=false;
				$( ".search" ).mousedown(function() {
					if(!searchButtonWasPressed)
					{
						searchPressed(this);			
					}else
					{
						searchLeave(this);
					}
					searchButtonWasPressed = !searchButtonWasPressed;
				});
				$( ".search" ).hover(function () {
					if(!searchButtonWasPressed)
					{
						searchPressed(this);			
					}
					},
					function () {
						if(!searchButtonWasPressed)
						{
							searchLeave(this);			
						}
					}); 
					
					function searchPressed(button){
						$('#viewerPanel').html("<div class=\"code-highlighter\">"+$("#"+button.title).html()+"</div>");
						if(lastSelected!=null)
						{
							lastSelected.removeClass("selected")
						}
						lastSelected=$("#"+button.title);
						$("#"+button.title).addClass("selected");
					}
					
					function searchLeave(button){
						$('#viewerPanel').html("");
						if(lastSelected!=null)
						{
							lastSelected.addClass("selected")
						}
						lastSelected=$("#"+button.title);
						lastSelected.removeClass("selected");
					}
}



