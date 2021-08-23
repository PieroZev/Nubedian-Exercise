import React from "react";
import SocketList from "./SocketList";
import {shallow} from 'enzyme';

describe('SocketList', ()=>{
  
  let wrapper;

  it("should render", () => {
    wrapper = shallow(<SocketList {...socketListProps}/>);
    expect(wrapper.exists()).toBe(true);
  });

});

const socketListProps = { 
  sockets:[],
  borrarSocket:null,
  editarSocket:null 
};