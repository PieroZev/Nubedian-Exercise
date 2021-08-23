import React from "react";
import CPU from "./CPU";
import {shallow} from 'enzyme';

describe('CPU', ()=>{
  
  let wrapper;

  it("should render", () => {
    wrapper = shallow(<CPU/>);
    expect(wrapper.exists()).toBe(true);
  });

});