var widgets = [
  {
    id: 1,
    name: "The Great Widget",
    price: 1000.00
  }
]

// index listing of widgets at /widgets/
exports.index = function (req, res) {
  res.send(widgets)
}

exports.httpget = function(req, res) {
  res.send(widgets)
}

// display new widget form
exports.new = function (req, res) {
  res.send('displaying new widget form')
}

// add a widget
exports.create = function (req, res) {
  var index = widgets.length + 1
  widgets[widgets.length] = {
    id: index,
    name: req.body.widgetname,
    price: parseFloat(req.body.widgetprice)
  }
  console.log(widgets[index - 1])
  res.send('Widget ' + req.body.widgetname + ' added with id ' + index)
}

// show a widget
exports.show = function (req, res) {
  var index = parseInt(req.params.id) - 1
  if (!widgets[index]) {
    res.send('There is no widget with id of ' + req.params.id)
  } else {
    res.send(widgets[index])
  }
}

// delete a widget
exports.destroy = function (req, res) {
  var index = req.params.id - 1
  delete widgets[index]

  console.log('deleted ' + req.params.id)
  res.send('deleted ' + req.params.id)
}

// display eidt form 
exports.edit = function (req, res) {
  res.send('displaying edit form')
}

// update a widget
exports.update = function (req, res) {
  var index = parseInt(req.params.id) - 1
  widgets[index] = {
    id: index + 1,
    name: req.body.widgetname,
    price: parseFloat(req.body.widgetprice)
  }
  console.log(widgets[index])
  res.send('Updated ' + req.params.id)
}