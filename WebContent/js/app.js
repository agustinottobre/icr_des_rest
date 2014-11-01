/*Ext.application({
   name: 'TSC',
   launch: function() {
    Ext.create('Ext.container.Viewport', {
    layout: 'fit',
    items: [
    {
     title: 'EXTJS: MyApp',
     html : 'Hello World!'
    }
   ]
  });
 }
});
*/
Ext.application({
   name: 'TSC',
   launch: function () {
    Ext.create('Ext.panel.Panel', {
    	layout: 'fit',
        renderTo: 'panelcontainer', // i've added div to html
        width: 1000,
        height: 600,
        items: [
            {
            	title: 'EXTJS: MyApp',
     			html : 'Hello World!'
     			/*
                xtype: 'tasklist',
                title: 'Tasks',
                html: 'List of tasks will go here'
                */
            }
        ]
    });
}
});

Ext.onReady(function() {
 Ext.Msg.alert('Status', '<h1>Hello World!<\/h1>');
});