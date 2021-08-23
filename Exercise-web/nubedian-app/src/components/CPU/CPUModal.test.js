import React from "react";
import CPUModal from "./CPUModal";
import {shallow} from 'enzyme';

describe('CPUModal', ()=>{
  
  let wrapper;

  it("should render", () => {
    wrapper = shallow(<CPUModal {...cpuModalProps}/>);
    expect(wrapper.exists()).toBe(true);
  });

});

const cpuModalProps = {
  show:null, 
  handleClose:null,
  handleChange:null,
  handleSubmit:null, 
  isEdit:null, 
  validate:null, 
  errorMsg:null,
  cpu:{
    model: '',
    brand: '',
    Sockets: new Array(),
    clockSpeed: 0.00,
    numberOfCores: 0,
    numberOfThreads: 0,
    tdp: 0.00,
    price: 0.00
  }
}