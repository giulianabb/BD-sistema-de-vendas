/*
 * Funções para manipular o datepicker.
 * 
 * */

$(document).ready(function(){
	
	$('#datetimepicker').datetimepicker({
        format: 'dd/MM/yyyy HH:mm:ss',
        pickDate: true,
        pickTime: false,
        language: 'pt-BR'
      }).on('changeDate', selecionaDiaSemana);
	
	
	$('#datetimepicker').data('datetimepicker').setLocalDate(new Date());
	selecionaDiaSemana();
	
	$('input[name="efetuado"][type="checkbox"]').change(function() {
		$('#data-pagamento').toggle();
	});
	
})

function selecionaDiaSemana() {
		var dataPedido = $('#datetimepicker').data('datetimepicker').getLocalDate();
  	  	var diaSemana = $.fn.datetimepicker.dates['pt-BR'].daysForSelect[dataPedido.getDay()];
  	  	$('select#diaSemana option[value=' + diaSemana + ']').prop('selected', true);
	}

	
      
      