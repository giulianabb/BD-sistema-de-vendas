$(document).ready(function() {
	
	/*$.fn.dataTable['enum']( ['Segunda-feira', 'Terça-feira', 'Quarta-feira', 'Quinta-feira', 'Sexta-feira', 'Sábado', 'Domingo'] );*/
	        	
	$('#table_todos').DataTable({
        language: {
        	"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        }
    });
	
	
	$('#table_simples').DataTable({
        language: {
        	"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        searching: false,
        paging: false
    });
});