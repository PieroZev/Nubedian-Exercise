import React from "react";
import CPUList from "./CPUList";
import {shallow} from 'enzyme';

describe('CPUList', ()=>{
  
  let wrapper;

  it("should render", () => {
    wrapper = shallow(<CPUList {...cpuListProps}/>);
    expect(wrapper.exists()).toBe(true);
  });

});

const cpuListProps = { 
  cpus:[],
  borrarCPU:null,
  editarCPU:null 
};