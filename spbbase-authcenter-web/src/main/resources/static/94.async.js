(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[94],{JeqK:function(e,t,a){"use strict";var i=a("3rQ3"),n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("79JM");var s=n(a("DmMy"));a("hjCg");var o=n(a("Feml")),r=n(a("Sx57")),d=n(a("4zp0")),c=n(a("iVWQ")),l=n(a("lF+r")),f=n(a("PApH")),p=i(a("zLBQ")),u=a("0iMl"),g=function(e){function t(){var e,a;(0,r.default)(this,t);for(var i=arguments.length,n=new Array(i),s=0;s<i;s++)n[s]=arguments[s];return a=(0,c.default)(this,(e=(0,l.default)(t)).call.apply(e,[this].concat(n))),a.getData=function(){var e=p.default.createElement(o.default,{checkedChildren:(0,u.formatMessage)({id:"app.settings.open"}),unCheckedChildren:(0,u.formatMessage)({id:"app.settings.close"}),defaultChecked:!0});return[{title:(0,u.formatMessage)({id:"app.settings.notification.password"},{}),description:(0,u.formatMessage)({id:"app.settings.notification.password-description"},{}),actions:[e]},{title:(0,u.formatMessage)({id:"app.settings.notification.messages"},{}),description:(0,u.formatMessage)({id:"app.settings.notification.messages-description"},{}),actions:[e]},{title:(0,u.formatMessage)({id:"app.settings.notification.todo"},{}),description:(0,u.formatMessage)({id:"app.settings.notification.todo-description"},{}),actions:[e]}]},a}return(0,f.default)(t,e),(0,d.default)(t,[{key:"render",value:function(){return p.default.createElement(p.Fragment,null,p.default.createElement(s.default,{itemLayout:"horizontal",dataSource:this.getData(),renderItem:function(e){return p.default.createElement(s.default.Item,{actions:e.actions},p.default.createElement(s.default.Item.Meta,{title:e.title,description:e.description}))}}))}}]),t}(p.Component),m=g;t.default=m}}]);