/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hannesdorfmann.mosby.sample.mail.base.view.viewstate;

import android.os.Parcel;
import android.os.Parcelable;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.CastedArrayListLceViewState;
import com.hannesdorfmann.mosby.sample.mail.base.view.AuthView;
import java.util.List;

/**
 * @author Hannes Dorfmann
 */
public class AuthCastedArrayListViewState<D extends List<? extends Parcelable>, V extends AuthView<D>>
    extends CastedArrayListLceViewState<D, V> implements AuthViewState<D, V> {

  public AuthCastedArrayListViewState(){
  }

  protected AuthCastedArrayListViewState(Parcel source) {
    super(source);
  }

  @Override public void apply(V view, boolean retained) {

    if (currentViewState == SHOWING_AUTHENTICATION_REQUIRED) {
      view.showAuthenticationRequired();
    } else {
      super.apply(view, retained);
    }
  }

  @Override public void setShowingAuthenticationRequired() {
    currentViewState = SHOWING_AUTHENTICATION_REQUIRED;

    // Delete any previous stored data
    loadedData = null;
    exception = null;
  }
}
