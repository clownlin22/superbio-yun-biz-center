(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[26],{"2AEw":function(e,t,a){"use strict";var l=a("xK3H"),r=a("3rQ3");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0,a("fhlT");var d=l(a("kXZy"));a("Lzml");var m=l(a("vpm+"));a("49Cq");var o=l(a("/OG3"));a("cFNL");var u=l(a("gOg5"));a("khen");var f=l(a("3J+T"));a("1pPU");var s=l(a("KjZ1")),i=l(a("dnxz")),n=l(a("Sx57")),c=l(a("4zp0")),p=l(a("iVWQ")),g=l(a("lF+r")),E=l(a("PApH"));a("/MhY");var b=l(a("w0+5"));a("9TwZ");var h=l(a("wOVV"));a("E2ON");var M=l(a("jjSt"));a("Q3sr");var v,F,y,w=l(a("9NP+")),q=r(a("zLBQ")),x=a("LneV"),k=a("0iMl"),N=l(a("zHco")),T=l(a("Zpge")),A=w.default.Item,C=M.default.Option,O=h.default.RangePicker,P=b.default.TextArea,S=(v=(0,x.connect)(function(e){var t=e.loading;return{submitting:t.effects["form/submitRegularForm"]}}),F=w.default.create(),v(y=F(y=function(e){function t(){var e,a;(0,n.default)(this,t);for(var l=arguments.length,r=new Array(l),d=0;d<l;d++)r[d]=arguments[d];return a=(0,p.default)(this,(e=(0,g.default)(t)).call.apply(e,[this].concat(r))),a.handleSubmit=function(e){var t=a.props,l=t.dispatch,r=t.form;e.preventDefault(),r.validateFieldsAndScroll(function(e,t){e||l({type:"form/submitRegularForm",payload:t})})},a}return(0,E.default)(t,e),(0,c.default)(t,[{key:"render",value:function(){var e=this.props.submitting,t=this.props.form,a=t.getFieldDecorator,l=t.getFieldValue,r={labelCol:{xs:{span:24},sm:{span:7}},wrapperCol:{xs:{span:24},sm:{span:12},md:{span:10}}},n={wrapperCol:{xs:{span:24,offset:0},sm:{span:10,offset:7}}};return q.default.createElement(N.default,{title:q.default.createElement(k.FormattedMessage,{id:"app.forms.basic.title"}),content:q.default.createElement(k.FormattedMessage,{id:"app.forms.basic.description"})},q.default.createElement(d.default,{bordered:!1},q.default.createElement(w.default,{onSubmit:this.handleSubmit,hideRequiredMark:!0,style:{marginTop:8}},q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement(k.FormattedMessage,{id:"form.title.label"})}),a("title",{rules:[{required:!0,message:(0,k.formatMessage)({id:"validation.title.required"})}]})(q.default.createElement(b.default,{placeholder:(0,k.formatMessage)({id:"form.title.placeholder"})}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement(k.FormattedMessage,{id:"form.date.label"})}),a("date",{rules:[{required:!0,message:(0,k.formatMessage)({id:"validation.date.required"})}]})(q.default.createElement(O,{style:{width:"100%"},placeholder:[(0,k.formatMessage)({id:"form.date.placeholder.start"}),(0,k.formatMessage)({id:"form.date.placeholder.end"})]}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement(k.FormattedMessage,{id:"form.goal.label"})}),a("goal",{rules:[{required:!0,message:(0,k.formatMessage)({id:"validation.goal.required"})}]})(q.default.createElement(P,{style:{minHeight:32},placeholder:(0,k.formatMessage)({id:"form.goal.placeholder"}),rows:4}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement(k.FormattedMessage,{id:"form.standard.label"})}),a("standard",{rules:[{required:!0,message:(0,k.formatMessage)({id:"validation.standard.required"})}]})(q.default.createElement(P,{style:{minHeight:32},placeholder:(0,k.formatMessage)({id:"form.standard.placeholder"}),rows:4}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement("span",null,q.default.createElement(k.FormattedMessage,{id:"form.client.label"}),q.default.createElement("em",{className:T.default.optional},q.default.createElement(k.FormattedMessage,{id:"form.optional"}),q.default.createElement(f.default,{title:q.default.createElement(k.FormattedMessage,{id:"form.client.label.tooltip"})},q.default.createElement(s.default,{type:"info-circle-o",style:{marginRight:4}}))))}),a("client")(q.default.createElement(b.default,{placeholder:(0,k.formatMessage)({id:"form.client.placeholder"})}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement("span",null,q.default.createElement(k.FormattedMessage,{id:"form.invites.label"}),q.default.createElement("em",{className:T.default.optional},q.default.createElement(k.FormattedMessage,{id:"form.optional"})))}),a("invites")(q.default.createElement(b.default,{placeholder:(0,k.formatMessage)({id:"form.invites.placeholder"})}))),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement("span",null,q.default.createElement(k.FormattedMessage,{id:"form.weight.label"}),q.default.createElement("em",{className:T.default.optional},q.default.createElement(k.FormattedMessage,{id:"form.optional"})))}),a("weight")(q.default.createElement(u.default,{placeholder:(0,k.formatMessage)({id:"form.weight.placeholder"}),min:0,max:100})),q.default.createElement("span",{className:"ant-form-text"},"%")),q.default.createElement(A,(0,i.default)({},r,{label:q.default.createElement(k.FormattedMessage,{id:"form.public.label"}),help:q.default.createElement(k.FormattedMessage,{id:"form.public.label.help"})}),q.default.createElement("div",null,a("public",{initialValue:"1"})(q.default.createElement(o.default.Group,null,q.default.createElement(o.default,{value:"1"},q.default.createElement(k.FormattedMessage,{id:"form.public.radio.public"})),q.default.createElement(o.default,{value:"2"},q.default.createElement(k.FormattedMessage,{id:"form.public.radio.partially-public"})),q.default.createElement(o.default,{value:"3"},q.default.createElement(k.FormattedMessage,{id:"form.public.radio.private"})))),q.default.createElement(A,{style:{marginBottom:0}},a("publicUsers")(q.default.createElement(M.default,{mode:"multiple",placeholder:(0,k.formatMessage)({id:"form.publicUsers.placeholder"}),style:{margin:"8px 0",display:"2"===l("public")?"block":"none"}},q.default.createElement(C,{value:"1"},q.default.createElement(k.FormattedMessage,{id:"form.publicUsers.option.A"})),q.default.createElement(C,{value:"2"},q.default.createElement(k.FormattedMessage,{id:"form.publicUsers.option.B"})),q.default.createElement(C,{value:"3"},q.default.createElement(k.FormattedMessage,{id:"form.publicUsers.option.C"}))))))),q.default.createElement(A,(0,i.default)({},n,{style:{marginTop:32}}),q.default.createElement(m.default,{type:"primary",htmlType:"submit",loading:e},q.default.createElement(k.FormattedMessage,{id:"form.submit"})),q.default.createElement(m.default,{style:{marginLeft:8}},q.default.createElement(k.FormattedMessage,{id:"form.save"}))))))}}]),t}(q.PureComponent))||y)||y),U=S;t.default=U}}]);