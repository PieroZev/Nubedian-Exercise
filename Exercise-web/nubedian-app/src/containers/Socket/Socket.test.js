import React from "react";
import Socket from "./Socket";
import {shallow} from 'enzyme';

describe('Socket', ()=>{
  
  let wrapper;

  it("should render", () => {
    wrapper = shallow(<Socket/>);
    expect(wrapper.exists()).toBe(true);
  });

});